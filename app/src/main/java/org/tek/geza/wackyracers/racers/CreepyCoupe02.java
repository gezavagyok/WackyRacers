package org.tek.geza.wackyracers.racers;

import org.tek.geza.wackyracers.abilities.concrete_abilities.SummoningAbility;
import org.tek.geza.wackyracers.engine.Engine;

/**
 * Big Gruesome - a Frankenstein's monster/ Lurch (The Addams Family) type - and Little Gruesome -
 * a purple skinned vampire - are monsters driving a car with a Belfry which housed a dragon and
 * various spooky characters. The Creepy Coupe was able to fly short distances through use of the
 * dragon's wings and has bats constantly circling its belfry. Also, they can summon bats, storms,
 * ghosts, serpents, and even a witch to help them fend off the other cars.
 */

public class CreepyCoupe02 extends RaceCar {

    public CreepyCoupe02(Engine engine, SummoningAbility specialAbility) {
        super(engine);

        name = "Creepy Coupe";
        drivers = new String[]{"Big Gruesome", "Little Gruesome", "Belfry"};
        ability = specialAbility;
        target = null;
    }
}
