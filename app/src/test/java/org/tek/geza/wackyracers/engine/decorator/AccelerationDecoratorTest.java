package org.tek.geza.wackyracers.engine.decorator;

import org.junit.Before;
import org.junit.Test;
import org.tek.geza.wackyracers.effect.MockEngine;
import org.tek.geza.wackyracers.engine.Engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by geza on 2016.08.21..
 */
public class AccelerationDecoratorTest {

    static final int FLAT_SPEED_INCREASE = 20;
    static final int DURATION = 1000; // 1s
    static final int BOOST_PERCENT = 100; // 100% boost

    AccelerationDecorator decorator;
    Engine engine = new MockEngine();

    @Before
    public void setUp() throws Exception {
        engine = new MockEngine();
        decorator = new AccelerationDecorator(engine, DURATION, BOOST_PERCENT); // 1 s, 100% bosst
        decorator.setFlatSpeedIncrease(FLAT_SPEED_INCREASE);
    }

    @Test
    public void setFlatSpeedIncrease() throws Exception {
        decorator.onAttach();
        assertNotEquals(engine.getMaxSpeed(), decorator.getMaxSpeed(), 0.001);
    }

    @Test
    public void getAcceleration() throws Exception {
        decorator.onAttach();
        assertEquals(engine.getAcceleration() * (1 + BOOST_PERCENT / 100), decorator.getAcceleration(), 0.001);
    }

    @Test
    public void getMaxSpeed() throws Exception {
        decorator.onAttach();
        assertEquals(engine.getMaxSpeed() + FLAT_SPEED_INCREASE, decorator.getMaxSpeed(), 0.001);
    }

}