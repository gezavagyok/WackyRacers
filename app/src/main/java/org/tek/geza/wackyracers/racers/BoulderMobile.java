package org.tek.geza.wackyracers.racers;

import org.tek.geza.wackyracers.abilities.SpecialAbility;
import org.tek.geza.wackyracers.engine.Engine;

/**
 * Rock and Gravel Slag are cavemen driving a wheeled boulder.
 * They are almost completely covered in wild and unkempt hair
 * and communicate mostly in grunts and broken mumbled phrases.
 * If their car is ever destroyed, the Slag Brothers will usually
 * reconstruct it from scratch simply by using their clubs on
 * any large boulder they can find. The Slag Brothers can also
 * summon up a Pteranodon to help them. They accelerate by
 * hitting the car (or at times, each other) with their clubs.
 * They will sometimes directly attack other drivers with their
 * clubs or by launching rocks at them.
 */
public class BoulderMobile extends RaceCar {

    public BoulderMobile(Engine engine, SpecialAbility specialAbility) {
        super(engine);
        name = "Boulder Mobile";
        drivers = new String[]{"Rock Slag", "Gravel Slag"};
        ability = specialAbility;
        target = this;
    }
}
