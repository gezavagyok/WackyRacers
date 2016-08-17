package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;
import org.tek.geza.wackyracers.racers.DefaultConfiguration;
import org.tek.geza.wackyracers.racers.TheDoubleZero;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.17..
 */
@Module(includes = {
        EngineModule.class
})
public class CarModule {

    @Provides
    @Singleton
    public TheDoubleZero provideTheDoubleZero(TopCarEngine topCarEngine){
        TheDoubleZero the00 = new TheDoubleZero(topCarEngine, new RocketPowering(new AccelerationDecorator(topCarEngine,3000,100)));
        return the00;
    }


}
