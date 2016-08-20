package org.tek.geza.wackyracers.abilities.concrete_abilities;

import org.tek.geza.wackyracers.abilities.CooldownAbility;
import org.tek.geza.wackyracers.effect.RepairEffect;

/**
 * Created by geza on 2016.08.18..
 */

public class ReconstructCar extends CooldownAbility {

    public static final long ABILITY_COOLDOWN = 60 * 1000; // 15 seconds

    public ReconstructCar(RepairEffect effect) {
        super("Reconstuction", effect, ABILITY_COOLDOWN);
    }
}
