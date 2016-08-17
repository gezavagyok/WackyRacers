package org.tek.geza.wackyracers.racers;

import android.util.Log;

import org.tek.geza.wackyracers.Effect;
import org.tek.geza.wackyracers.abilities.SpecialAbility;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class RaceCar {
    private static final String TAG = "RACE";
    String name;
    String[] drivers;

    SpecialAbility ability;
    RaceCar target;

    double maxSpeed;
    double currentSpeed;
    double acceleration;
    double damaged;
    double fuel;

    DefaultConfiguration defaultConfiguration;

    Subscription subscription;

    public void useAbility(){
        subscription = ability.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(target::react)
                .doOnCompleted(() -> Log.i(TAG, ability.getName() + " has been used on "+target.getName()+" !"))
                .doOnError(this::handleError)
                .subscribe();
    }

    public void react(Effect effect){
        effect.apply(this);
        Log.i(TAG, "applying effect: " +effect.toString() );
    }

    void handleError(Throwable throwable){
        Log.d("RACE","ERROR: " + throwable.getMessage());
    }

    public void destroy(){
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }


    /**
     *
     * getters and setters below
     *
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

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDamaged() {
        return damaged;
    }

    public void setDamaged(double damaged) {
        this.damaged = damaged;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public DefaultConfiguration getDefaultConfiguration() {
        return defaultConfiguration;
    }

    public void setDefaultConfiguration(DefaultConfiguration defaultConfiguration) {
        this.defaultConfiguration = defaultConfiguration;
    }

    public abstract void clearBonus();
}