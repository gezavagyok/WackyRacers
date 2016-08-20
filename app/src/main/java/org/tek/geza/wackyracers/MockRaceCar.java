package org.tek.geza.wackyracers;

import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.20..
 */

public class MockRaceCar extends RaceCar {

    public MockRaceCar() {
        super(new TopCarEngine(0, 8.5, 100, 0, 100));
    }

}
