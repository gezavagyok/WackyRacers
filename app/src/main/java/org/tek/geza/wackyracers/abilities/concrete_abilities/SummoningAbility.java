package org.tek.geza.wackyracers.abilities.concrete_abilities;

import org.tek.geza.wackyracers.abilities.CooldownAbility;
import org.tek.geza.wackyracers.effect.Effect;

/**
 * Created by geza on 2016.08.21..
 */
public class SummoningAbility extends CooldownAbility {

    public SummoningAbility(String name, Effect effect, long cooldownTime) {
        super(name, effect, cooldownTime);
    }
}
