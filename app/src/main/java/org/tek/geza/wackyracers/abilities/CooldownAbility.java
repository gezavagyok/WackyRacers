package org.tek.geza.wackyracers.abilities;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class CooldownAbility implements SpecialAbility {
    protected final double cooldown;
    protected double cooldownLasts;

    public CooldownAbility(double cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isAbilityReady(){
        return true; // todo
    }

    public double timeLeft(){
        return 0.0; // todo
    }
}
