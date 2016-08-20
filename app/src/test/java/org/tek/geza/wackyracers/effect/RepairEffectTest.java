package org.tek.geza.wackyracers.effect;

import org.junit.Before;
import org.junit.Test;
import org.tek.geza.wackyracers.MockRaceCar;

/**
 * Created by geza on 2016.08.20..
 */
public class RepairEffectTest {

    RepairEffect effect;

    @Before
    public void setUp() throws Exception {
        effect = new RepairEffect("repaireffect");

    }

    @Test
    public void apply() throws Exception {
        System.out.println("Testing applying repair effect");
        effect.apply(new MockRaceCar());
    }

}