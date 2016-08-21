package org.tek.geza.wackyracers.racers;

import org.tek.geza.wackyracers.abilities.SpecialAbility;
import org.tek.geza.wackyracers.engine.Engine;

/**
 * Dastardly's rocket car was arguably the fastest car in the series,
 * as evidenced by Dastardly's repeatedly zooming to a stunning lead
 * from far behind. Dastardly never saw victory, but came close at
 * least three times: once when he crossed the line first, and is
 * seen to do so in the original and official footage, but a tampered
 * replay viewed by the judges showed him cheating, and another time
 * when he was battling with three other cars to finish first, but he
 * stopped to pose for the photo finish. He also came close to
 * winning another race, but he stopped again, this time to sign an
 * autograph for Muttley.
 *
 * @source https://en.wikipedia.org/wiki/Wacky_Races
 */
public class TheMeanMachine00 extends RaceCar {

    public TheMeanMachine00(Engine carEngine, SpecialAbility rocketPowering) {
        super(carEngine);
        name = "The Double Zero";
        drivers = new String[]{"Dick Dastardly", "Muttley"};
        ability = rocketPowering;
        target = this;
    }
}
