package org.tek.geza.wackyracers.racers;

/**
 * Created by geza on 2016.08.17..
 */

public class DefaultConfiguration {
    double maxSpeed;
    double currentSpeed;
    double acceleration;
    double damaged;
    double fuel;

    public DefaultConfiguration(double maxSpeed, double currentSpeed, double acceleration, double damaged, double fuel) {
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.acceleration = acceleration;
        this.damaged = damaged;
        this.fuel = fuel;
    }
}
