package org.tek.geza.wackyracers.engine;

/**
 * Created by geza on 2016.08.17..
 */
public class WeakCarEngine extends CarEngine {

    public WeakCarEngine(double velocity, double acceleration, double fuelLeft, double damage/*haha*/, double maxSpeed) {
        setVelocity(velocity);
        setAcceleration(acceleration);
        setFuelLeft(fuelLeft);
        setDamage(damage);
        setMaxSpeed(maxSpeed);
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public double getAcceleration() {
        return acceleration;
    }

    @Override
    public double getFuelLeft() {
        return fuelLeft;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getMaxSpeed() {
        return maxSpeed;
    }
}
