package org.tek.geza.wackyracers.effect;

import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketEffect extends TempEffect {

    public RocketEffect(AccelerationDecorator decorator) {
        super("Rocket effect", decorator);
    }
}
