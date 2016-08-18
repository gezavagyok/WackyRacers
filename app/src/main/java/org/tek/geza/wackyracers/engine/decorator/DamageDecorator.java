package org.tek.geza.wackyracers.engine.decorator;

import org.tek.geza.wackyracers.engine.Engine;

/**
 * Created by geza on 2016.08.18..
 */
public class DamageDecorator extends EngineDecorator {

    public DamageDecorator(Engine engine) {
        super(engine, 500); // completed over 500 ms
    }

    @Override
    public double getDamage() {
        return super.getDamage() * 0;
    }


}
