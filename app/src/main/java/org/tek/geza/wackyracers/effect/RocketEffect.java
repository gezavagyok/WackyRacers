package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.Engine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketEffect extends TempEffect {

    public RocketEffect(Engine engine, AccelerationDecorator decorator) {
        super("Rocket effect", decorator);
    }
}
