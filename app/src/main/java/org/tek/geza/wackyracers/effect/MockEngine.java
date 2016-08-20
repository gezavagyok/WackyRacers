package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.Engine;

/**
 * Created by geza on 2016.08.20..
 */

public class MockEngine implements Engine {

    @Override
    public double getVelocity() {
        return 0;
    }

    @Override
    public double getAcceleration() {
        return 0;
    }

    @Override
    public double getFuelLeft() {
        return 0;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getMaxSpeed() {
        return 0;
    }

    @Override
    public void repair() {
        System.out.println("repair effect in progress");
    }
}
