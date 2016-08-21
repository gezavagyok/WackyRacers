package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.Engine;

/**
 * Created by geza on 2016.08.20..
 */

public class MockEngine implements Engine {

    @Override
    public double getVelocity() {
        return 10;
    }

    @Override
    public double getAcceleration() {
        return 10;
    }

    @Override
    public double getFuelLeft() {
        return 20;
    }

    @Override
    public double getDamage() {
        return 30;
    }

    @Override
    public double getMaxSpeed() {
        return 50;
    }

    @Override
    public void repair() {
        System.out.println("repair effect in progress");
    }
}
