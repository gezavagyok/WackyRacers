package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.20..
 */

public class RepairEffect extends Effect {

    public RepairEffect(String name) {
        super("Repair effect");
    }

    @Override
    public void apply(RaceCar raceCar) {
        raceCar.getEngine().repair();
    }
}
