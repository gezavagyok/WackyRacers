package org.tek.geza.wackyracers.racers;

import org.junit.Before;
import org.junit.Test;
import org.tek.geza.wackyracers.Effect;
import org.tek.geza.wackyracers.abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.CarEngine;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import java.util.concurrent.TimeUnit;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by geza on 2016.08.18..
 */
public class TheDoubleZeroTest {

    TheDoubleZero theDoubleZero;

    @Before
    public void setUp() throws Exception {
        CarEngine engine = new TopCarEngine(0, 8.5, 100, 0, 100);
        RocketPowering ability = new RocketPowering(new AccelerationDecorator(engine, 3000, 100));
        theDoubleZero = new TheDoubleZero(engine, ability);
    }

    @Test
    public void testCooldown() {
        theDoubleZero.useAbility()
                .doOnCompleted(() -> System.out.println("ability has been used first time."))
                // this should not happen! always fail in this case!
                .onErrorReturn(throwable -> {
//                    assertNotNull(throwable.getMessage());
                    System.out.println("error message: " + throwable.getMessage());

                    return Effect.error();
                })
                .toBlocking()
                .subscribe();
        System.out.println("cooldown will not be ready yet");
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(2)
                .doOnCompleted(() -> theDoubleZero.useAbility()
                        .doOnCompleted(() -> System.out.println("ability has been used second time."))
                        .onErrorReturn(throwable -> {
                            assertNotNull(throwable.getMessage());
                            System.out.println("ability failed: " + throwable.getMessage());
                            return Effect.error();
                        }).toBlocking().subscribe()
                )
                .toBlocking()
                .subscribe();
        System.out.println("cooldown works!");

    }

    @Test
    public void cooldownRefreshedTest() {
        theDoubleZero.useAbility()
                .doOnCompleted(() -> System.out.println("ability has been used first time."))
                // this should not happen! always fail in this case!
                .onErrorReturn(throwable -> {
//                    assertNotNull(throwable.getMessage());
                    System.out.println("error message: " + throwable.getMessage());
                    return Effect.error();
                })
                .toBlocking()
                .subscribe();
        // cooldown refreshed!
        System.out.println("cooldown should be refreshed");
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take((int) (RocketPowering.COOLDOWN + 2))
                .doOnCompleted(() -> theDoubleZero.useAbility()
                        .doOnCompleted(() -> System.out.println("ability has been used second time."))
                        .onErrorReturn(throwable -> {
                            assertNotNull(throwable.getMessage());
                            System.out.println("ability failed: " + throwable.getMessage());
                            // shouldnt happen!
                            assertEquals("cooldown is active still :(", 1, 2);
                            return Effect.error();
                        }).toBlocking().subscribe()
                )
                .toBlocking()
                .subscribe();
    }

}