package org.tek.geza.wackyracers.abilities.concrete_abilities;

import org.tek.geza.wackyracers.effect.Effect;

/**
 * Created by geza on 2016.08.21..
 */

public class SummonBats extends SummoningAbility {

    public static final long ABILITY_COOLDOWN = 20 * 1000; // 20 seconds

    public SummonBats(Effect effect) {
        super("Summon Bats", effect, ABILITY_COOLDOWN);
    }

}
