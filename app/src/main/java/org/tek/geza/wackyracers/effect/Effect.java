package org.tek.geza.wackyracers.effect;

import android.support.annotation.NonNull;

import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class Effect {

    static Effect errorEffect;
    protected final String name;

    public Effect(String name) {
        this.name = name;
    }

    public static Effect error() {
        if (errorEffect == null) {
            errorEffect = new TempEffect("ERROR", null);
        }
        return errorEffect;
    }

    public String getName() {
        return name;
    }

    public abstract void apply(@NonNull RaceCar raceCar);

    @Override
    public String toString() {
        return name;
    }
}
