package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.ReconstructCar;
import org.tek.geza.wackyracers.abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.Engine;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;
import org.tek.geza.wackyracers.engine.decorator.DamageDecorator;

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

    @Provides
    ReconstructCar provideReconstructCar(Engine engine) {
        return new ReconstructCar(new DamageDecorator(engine));
    }
}
