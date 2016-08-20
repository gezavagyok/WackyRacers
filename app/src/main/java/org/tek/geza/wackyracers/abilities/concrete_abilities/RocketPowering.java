package org.tek.geza.wackyracers.abilities.concrete_abilities;

import org.tek.geza.wackyracers.abilities.CooldownAbility;
import org.tek.geza.wackyracers.effect.RocketEffect;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketPowering extends CooldownAbility {

    public static final long ABILITY_COOLDOWN = 15 * 1000; // 15 seconds

    public RocketPowering(RocketEffect effect) {
        super("Rocket Powered", effect, ABILITY_COOLDOWN);
    }

}
