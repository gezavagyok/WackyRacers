package org.tek.geza.wackyracers.racers;

import android.util.Log;

import org.tek.geza.wackyracers.abilities.SpecialAbility;
import org.tek.geza.wackyracers.effect.Effect;
import org.tek.geza.wackyracers.engine.Engine;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class RaceCar {
    private static final String TAG = "RACE";
    String name;
    String[] drivers;

    SpecialAbility ability;
    Engine engine;
    RaceCar target;
    Subscription subscription;

    public RaceCar(Engine engine) {
        this.engine = engine;
    }

    public Observable<Effect> useAbility() {
        return ability.execute()
                .subscribeOn(Schedulers.io()) // subscribe on, observe on should go to view
                .doOnNext(target::react)
                .doOnCompleted(() -> Log.i(TAG, ability.getName() + " has been used on " + target.getName() + " !"));
    }

    public void react(Effect effect) {
        if (Effect.error().equals(effect)) {
            return;
        }

        effect.apply(this);
        Log.i(TAG, "applying effect: " + effect.toString());
    }

    void handleError(Throwable throwable) {
        Log.d("RACE", "ERROR: " + throwable.getMessage());
    }

    public void destroy() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


    /**
     * getters and setters below
     */

    public RaceCar getTarget() {
        return target;
    }

    public void setTarget(RaceCar target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}