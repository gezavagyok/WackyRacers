package org.tek.geza.wackyracers.engine.decorator;

import org.tek.geza.wackyracers.engine.Engine;

/**
 * Like firing up a rocket
 */
public class AccelerationDecorator extends EngineDecorator {

    double percent;
    double flatSpeedIncrease;

    public AccelerationDecorator(Engine engine, long duration, double percent) {
        super(engine, duration);
        this.percent = percent;
    }

    public void setFlatSpeedIncrease(double flatSpeedIncrease) {
        this.flatSpeedIncrease = flatSpeedIncrease;
    }

    @Override
    public double getAcceleration() {
        if (!isDetached()) {
            return super.getAcceleration() * percent;
        } else {
            return super.getAcceleration();
        }

    }

    @Override
    public double getMaxSpeed() {
        if (!isDetached()) {
            return super.getMaxSpeed() + flatSpeedIncrease;
        } else {
            return super.getMaxSpeed();
        }

    }
}
