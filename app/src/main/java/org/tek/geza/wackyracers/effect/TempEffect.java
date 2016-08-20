package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.decorator.EngineDecorator;
import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.18..
 */

public class TempEffect extends Effect {

    final EngineDecorator engineDecorator;

    public TempEffect(String name, EngineDecorator decorator) {
        super(name);
        engineDecorator = decorator;
    }

    @Override
    public void apply(RaceCar raceCar) {
        raceCar.setEngine(engineDecorator);
        engineDecorator.onAttach();
    }
}
