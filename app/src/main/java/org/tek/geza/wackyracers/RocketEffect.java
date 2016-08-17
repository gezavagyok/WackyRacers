package org.tek.geza.wackyracers;

import org.tek.geza.wackyracers.engine.Engine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketEffect extends Effect {

    public RocketEffect(Engine engine) {
        super(new AccelerationDecorator(engine,3000,100));
        name = "Rocket effect";
    }
}
