package org.tek.geza.wackyracers.racers;

import android.util.Log;

import org.tek.geza.wackyracers.abilities.RocketPowering;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public class TheDoubleZero extends RaceCar {

    private static final String TAG = "RACE";

    public TheDoubleZero() {
        name = "The Double Zero";
        drivers = new String[] { "Dick Dastardly", "Muttley"};
        ability = new RocketPowering();
        target = this;
    }

    @Override
    public void clearBonus() {
        setMaxSpeed(defaultConfiguration.maxSpeed);
        Log.i(TAG, "speed is: " + currentSpeed);
        if(currentSpeed > maxSpeed) {
            Log.i(TAG, "that is greater than " + maxSpeed);
            int DECCELERATE_TIME = 3;
            double difference = currentSpeed-maxSpeed;
            final double acceleration = difference / -DECCELERATE_TIME;
            setAcceleration(acceleration);
            Observable.interval(0,1,TimeUnit.SECONDS, Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .take(DECCELERATE_TIME)
                    .doOnNext(this::adjustAcceleration)
                    .doOnCompleted(() -> Log.i(TAG, "clearBonus: bonus has been depleted!"))
                    .subscribe();
        }
    }

    void adjustAcceleration(Long l){
        currentSpeed += acceleration;
        Log.i(TAG, "speed: "+currentSpeed);

        if(currentSpeed <= maxSpeed) {
            setAcceleration(0);
        }
    }
}
