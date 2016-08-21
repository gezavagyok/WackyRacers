package org.tek.geza.wackyracers.engine.decorator;

/**
 * Created by geza on 2016.08.21..
 */
public class VelocitySlowingDecorator extends FutureEngineDecorator {

    double slowedPercent;

    public VelocitySlowingDecorator(long duration, double percent) {
        super(duration);
        slowedPercent = percent;
    }

    @Override
    public double getVelocity() {
        if (!isDetached()) {
            return super.getVelocity() * slowedPercent;
        } else {
            return super.getVelocity();
        }
    }
}
