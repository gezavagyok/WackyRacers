package org.tek.geza.wackyracers;

import org.tek.geza.wackyracers.engine.decorator.EngineDecorator;
import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.17..
 */

public class Effect {
    private static final String TAG = "RACE";
    static Effect errorEffect;
    final EngineDecorator decorator;
    protected String name;

    public Effect(EngineDecorator decorator) {
        this.decorator = decorator;
    }

    public static Effect error() {
        if (errorEffect == null) {
            errorEffect = new Effect(null);
            errorEffect.setName("ERROR");
        }
        return errorEffect;
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
