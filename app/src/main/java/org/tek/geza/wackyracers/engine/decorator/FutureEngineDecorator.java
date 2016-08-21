package org.tek.geza.wackyracers.engine.decorator;

import org.tek.geza.wackyracers.engine.Engine;

/**
 * Created by geza on 2016.08.21..
 */

public abstract class FutureEngineDecorator extends EngineDecorator {

    public FutureEngineDecorator(long duration) {
        super(null, duration);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public double getVelocity() {
        if (engine == null) {
            return 0;
        }
        return engine.getVelocity();
    }

    @Override
    public double getAcceleration() {
        if (engine == null) {
            return 0;
        }
        return engine.getAcceleration();
    }

    @Override
    public double getFuelLeft() {
        if (engine == null) {
            return 0;
        }
        return engine.getFuelLeft();
    }

    @Override
    public double getDamage() {
        if (engine == null) {
            return 0;
        }
        return engine.getDamage();
    }

    @Override
    public double getMaxSpeed() {
        if (engine == null) {
            return 0;
        }
        return engine.getMaxSpeed();
    }

    @Override
    public void repair() {
        if (engine == null) {
            return;
        }
        engine.repair();
    }
}
