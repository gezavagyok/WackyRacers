package org.tek.geza.wackyracers.abilities;

/**
 * Created by geza on 2016.08.17..
 */

public abstract class CooldownAbility implements SpecialAbility {
    protected final long cooldown; // milliseconds
    protected long timeLeft;
    protected boolean isReady = true;

    public CooldownAbility(long cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isAbilityReady(){
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public long getCooldown() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }
}
