package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.decorator.FutureEngineDecorator;
import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.21..
 */

public class SlowingEffect extends TempEffect {

    public SlowingEffect(FutureEngineDecorator velocitySlowingDecorator) {
        super("Slow", velocitySlowingDecorator);
    }

    @Override
    public void apply(RaceCar raceCar) {
        ((FutureEngineDecorator) engineDecorator).setEngine(raceCar.getEngine());
        raceCar.setEngine(engineDecorator);
        engineDecorator.onAttach();
    }
}
