package org.tek.geza.wackyracers.abilities;

import android.util.Log;

import org.tek.geza.wackyracers.Effect;
import org.tek.geza.wackyracers.engine.decorator.DamageDecorator;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.18..
 */

public class ReconstructCar extends CooldownAbility {

    public static final long COOLDOWN = 15 * 1000; // 15 seconds
    private final static String TAG = "RACE";
    DamageDecorator decorator;

    public ReconstructCar(DamageDecorator damageDecorator) {
        super(500);
        decorator = damageDecorator;
    }

    @Override
    public Observable<Effect> execute() {
        return Observable.create(subscriber -> {
            if (isAbilityReady()) {
                Effect reconstructEffect = new Effect(decorator);
                reconstructEffect.setName("Reconstruction");
                subscriber.onStart();

                subscriber.onNext(reconstructEffect);

                setReady(false);
                Observable.interval(0, 100, TimeUnit.MILLISECONDS, Schedulers.io())
                        .take((int) COOLDOWN / 100)
                        .doOnNext(this::setTimeLeft)
                        .doOnCompleted(() -> {
                            setReady(true);
                            Log.i(TAG, "cooldown on " + reconstructEffect.toString() + " has been refreshed!");
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
        return "Reconstruct";
    }
}
