package org.tek.geza.wackyracers.engine;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class CarEngine implements Engine {

    protected double velocity;
    protected double acceleration;
    protected double fuelLeft;
    protected double damage;
    protected double maxSpeed;

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setFuelLeft(double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // upgrades to a better engine
    public void upgrade() {
        // todo...
    }
}
