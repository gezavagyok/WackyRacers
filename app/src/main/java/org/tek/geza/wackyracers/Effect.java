package org.tek.geza.wackyracers;

import android.util.Log;

import org.tek.geza.wackyracers.engine.decorator.EngineDecorator;
import org.tek.geza.wackyracers.racers.RaceCar;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by geza on 2016.08.17..
 */

public class Effect {
    private static final String TAG = "RACE";
    protected String name;

    final EngineDecorator decorator;

    public Effect(EngineDecorator decorator) {
        this.decorator = decorator;
    }

    public void apply(RaceCar raceCar){
        raceCar.setEngine(decorator); // +100% acceleration for 3 secs
        decorator.onAttach();
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
