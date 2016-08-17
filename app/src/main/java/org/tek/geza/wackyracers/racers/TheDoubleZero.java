package org.tek.geza.wackyracers.racers;

import org.tek.geza.wackyracers.abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.CarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import javax.inject.Inject;

/**
 * Created by geza on 2016.08.17..
 */

public class TheDoubleZero extends RaceCar {

    private static final String TAG = "RACE";

    public TheDoubleZero(CarEngine carEngine, RocketPowering rocketPowering) {
        super(carEngine);
        name = "The Double Zero";
        drivers = new String[] { "Dick Dastardly", "Muttley"};
        ability = rocketPowering;
        target = this;
    }

}
