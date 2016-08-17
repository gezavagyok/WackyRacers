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
        return super.getAcceleration() * percent;
    }

    @Override
    public double getMaxSpeed() {
        return super.getMaxSpeed() + flatSpeedIncrease;
    }
}
