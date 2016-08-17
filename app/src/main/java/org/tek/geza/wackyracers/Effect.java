package org.tek.geza.wackyracers;

import android.util.Log;

import org.tek.geza.wackyracers.racers.RaceCar;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public class Effect {
    private static final String TAG = "RACE";
    String name;
    final double adjustAcceleration;
    final double adjustDamage;
    final double adjustFuel;
    final double adjustCurrentSpeed;
    final double adjustMaxSpeed;

    final double duration;

    public Effect(double adjustAcceleration, double adjustDamage, double adjustFuel, double adjustCurrentSpeed, double adjustMaxSpeed, double duration) {
        this.adjustAcceleration = adjustAcceleration;
        this.adjustDamage = adjustDamage;
        this.adjustFuel = adjustFuel;
        this.adjustCurrentSpeed = adjustCurrentSpeed;
        this.adjustMaxSpeed = adjustMaxSpeed;
        this.duration = duration;
    }

    public void apply(RaceCar raceCar){
        raceCar.setAcceleration(raceCar.getAcceleration()*1+adjustAcceleration/100.0);
        raceCar.setDamaged(raceCar.getDamaged()+adjustDamage);
        raceCar.setFuel(raceCar.getFuel()+adjustFuel);
        raceCar.setCurrentSpeed(raceCar.getCurrentSpeed()+adjustCurrentSpeed);
        raceCar.setMaxSpeed(raceCar.getMaxSpeed()+adjustMaxSpeed);
        Log.i(TAG, "apply interval: " + (int)duration + "(s) is starting now!");
        Observable.interval(0,1, TimeUnit.SECONDS, Schedulers.io())
                .take((int)duration)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(aLong -> Log.i(TAG, "value: " + aLong))
                .doOnCompleted(raceCar::clearBonus)
                .subscribe();
    }

    public double getAdjustAcceleration() {
        return adjustAcceleration;
    }

    public double getAdjustDamage() {
        return adjustDamage;
    }

    public double getAdjustFuel() {
        return adjustFuel;
    }

    public double getAdjustCurrentSpeed() {
        return adjustCurrentSpeed;
    }

    public double getAdjustMaxSpeed() {
        return adjustMaxSpeed;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }
}
