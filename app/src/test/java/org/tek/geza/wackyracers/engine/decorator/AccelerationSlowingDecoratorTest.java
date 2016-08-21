package org.tek.geza.wackyracers.engine.decorator;

import org.junit.Before;
import org.junit.Test;
import org.tek.geza.wackyracers.effect.MockEngine;
import org.tek.geza.wackyracers.engine.Engine;

import static org.junit.Assert.assertEquals;

/**
 * Created by geza on 2016.08.21..
 */
public class AccelerationSlowingDecoratorTest {

    static final int FLAT_SPEED_INCREASE = 20;
    static final int DURATION = 1000; // 1s
    static final int BOOST_PERCENT = 0; // -100% boost

    AccelerationSlowingDecorator decorator;
    Engine engine = new MockEngine();

    @Before
    public void setUp() throws Exception {
        decorator = new AccelerationSlowingDecorator(DURATION, BOOST_PERCENT);
        decorator.setEngine(engine);
    }

    @Test
    public void getAcceleration() throws Exception {
        decorator.onAttach();
        assertEquals(engine.getAcceleration() * BOOST_PERCENT, decorator.getAcceleration(), 0.001);
    }

}