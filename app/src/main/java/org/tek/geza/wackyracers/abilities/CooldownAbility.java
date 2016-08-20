package org.tek.geza.wackyracers.abilities;

import android.util.Log;

import org.tek.geza.wackyracers.effect.Effect;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class CooldownAbility implements SpecialAbility {
    private final static String TAG = "RACE";
    final long COOLDOWN; // 15 seconds
    protected long timeLeft;
    protected boolean isReady = true;
    Effect effectToApply;
    String name;

    public CooldownAbility(String name, Effect effect, long cooldownTime) {
        COOLDOWN = cooldownTime;
        effectToApply = effect;
        this.name = name;
    }

    @Override
    public Observable<Effect> execute() {
        return Observable.create(subscriber -> {
            if (isAbilityReady()) {
                subscriber.onStart();

                subscriber.onNext(effectToApply);

                setReady(false);
                Observable.interval(0, 100, TimeUnit.MILLISECONDS, Schedulers.io())
                        .take((int) COOLDOWN / 100)
                        .doOnNext(this::setTimeLeft)
                        .doOnCompleted(() -> {
                            setReady(true);
                            Log.i(TAG, "cooldown on " + effectToApply.toString() + " has been refreshed!");
                        })
                        .subscribe();
                subscriber.onCompleted();
            } else {
                subscriber.onError(new CooldownLeftException("Ability ready in: " + (COOLDOWN / 100 - getCooldown()) / 10.0 + "s"));
            }
        });
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isAbilityReady(){
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public long getCooldown() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }
}
