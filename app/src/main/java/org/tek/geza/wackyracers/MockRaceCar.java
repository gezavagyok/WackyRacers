package org.tek.geza.wackyracers;

import org.tek.geza.wackyracers.effect.MockEngine;
import org.tek.geza.wackyracers.racers.RaceCar;

/**
 * Created by geza on 2016.08.20..
 */
public class MockRaceCar extends RaceCar {

    public MockRaceCar() {
        super(new MockEngine());
    }
}
