package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.18..
 */
@Module(includes = {
        EngineModule.class
})
public class AbilityModule {
    @Provides
    RocketPowering provideRocketPowering(TopCarEngine engine) {
        return new RocketPowering(new AccelerationDecorator(engine, 3000, 100));
    }
}
