package org.tek.geza.wackyracers.engine.decorator;

/**
 * Created by geza on 2016.08.21..
 */

public class AccelerationSlowingDecorator extends FutureEngineDecorator {

    double slowedPercent;

    public AccelerationSlowingDecorator(long duration, double percent) {
        super(duration);
        slowedPercent = percent;
    }

    @Override
    public double getAcceleration() {
        if (!isDetached()) {
            return super.getAcceleration() * slowedPercent;
        } else {
            return super.getAcceleration();
        }
    }
}
