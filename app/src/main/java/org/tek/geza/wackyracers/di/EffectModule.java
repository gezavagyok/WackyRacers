package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.effect.RepairEffect;
import org.tek.geza.wackyracers.effect.RocketEffect;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.20..
 */
@Module(includes = {
        EngineModule.class
})
public class EffectModule {
    @Provides
    RocketEffect provideRocketEffect(TopCarEngine engine) {
        return new RocketEffect(engine, new AccelerationDecorator(engine, 3000, 100));
    }

    @Provides
    RepairEffect provideRepairEffect() {
        return new RepairEffect("Repair");
    }
}
