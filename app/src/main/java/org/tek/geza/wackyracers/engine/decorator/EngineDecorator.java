package org.tek.geza.wackyracers.engine.decorator;

import android.util.Log;

import org.tek.geza.wackyracers.engine.Engine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class EngineDecorator implements Engine {

    private static final String TAG = "RACE";

    protected Engine engine;
    private long duration; // ms
    private boolean detached;

    public EngineDecorator(Engine engine, long duration) {
        this.engine = engine;
        this.duration = duration;
        detached = true;
    }

    @Override
    public double getVelocity() {
        return engine.getVelocity();
    }

    @Override
    public double getAcceleration() {
        return engine.getAcceleration();
    }

    @Override
    public double getFuelLeft() {
        return engine.getFuelLeft();
    }

    @Override
    public double getDamage() {
        return engine.getDamage();
    }

    @Override
    public double getMaxSpeed() {
        return engine.getMaxSpeed();
    }

    public final void onAttach(){
        detached = false;
        // timer starts:
        Log.i(TAG, "timer starts");
        Observable.interval(0,duration, TimeUnit.MILLISECONDS, Schedulers.io())
                .skip(1)
                .first()
                .doOnNext(aLong -> detached = true)
                .doOnCompleted(()-> Log.i(TAG, "decorator finished adjusting back to normal mode"))
                .subscribe();
    }

    public boolean isDetached() {
        return detached;
    }

    @Override
    public void repair() {
        engine.repair();
    }
}
