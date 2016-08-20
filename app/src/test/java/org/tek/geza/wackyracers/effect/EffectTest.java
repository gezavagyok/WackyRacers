package org.tek.geza.wackyracers.effect;

import org.junit.Before;
import org.junit.Test;
import org.tek.geza.wackyracers.MockRaceCar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by geza on 2016.08.20..
 */
public class EffectTest {

    Effect effect;

    @Before
    public void setUp() throws Exception {
        effect = new RepairEffect("TEST");
    }

    @Test
    public void error() throws Exception {
        System.out.println("Testing error effect");
        assertEquals(Effect.error().getName(), "ERROR");
    }

    @Test
    public void getName() throws Exception {
        System.out.println("Testing name");
        assertNotNull(effect.getName());
    }

    @Test
    public void apply() throws Exception {
        System.out.println("Testing apply effect");
        // for null
        try {
            effect.apply(null);
        } catch (NullPointerException npe) {
        }
        // for mock:
        effect.apply(new MockRaceCar());
    }
}