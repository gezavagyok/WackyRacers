package org.tek.geza.wackyracers.abilities;

import android.util.Log;

import org.tek.geza.wackyracers.Effect;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketPowering extends CooldownAbility {

    public static final long COOLDOWN = 15 * 1000; // 15 seconds
    private final static String TAG = "RACE";
    AccelerationDecorator decorator;

    @Inject
    public RocketPowering(AccelerationDecorator decorator) {
        super(COOLDOWN);
        this.decorator = decorator;
    }

    @Override
    public Observable<Effect> execute() {
        return Observable.create(subscriber -> {
            if(isAbilityReady()) {
                Effect rocketEffect = new Effect(decorator);
                rocketEffect.setName("Rocket Powered");
                subscriber.onStart();

                subscriber.onNext(rocketEffect);

                setReady(false);
                Observable.interval(0, 100, TimeUnit.MILLISECONDS, Schedulers.io())
                        .take((int) COOLDOWN / 100)
                        .doOnNext(this::setTimeLeft)
                        .doOnCompleted(() -> {
                            setReady(true);
                            Log.i(TAG, "cooldown on " + rocketEffect.toString() + " has been refreshed!");
                        })
                        .subscribe();
                subscriber.onCompleted();
            } else {
                subscriber.onError(new CooldownLeftException("Ability ready in: " + (cooldown / 100 - getCooldown()) / 10.0 + "s"));
            }
        });
    }

    @Override
    public String getName() {
        return "Rocket Powered";
    }
}
