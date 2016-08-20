package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.concrete_abilities.ReconstructCar;
import org.tek.geza.wackyracers.abilities.concrete_abilities.RocketPowering;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.WeakCarEngine;
import org.tek.geza.wackyracers.racers.BoulderMobile;
import org.tek.geza.wackyracers.racers.TheDoubleZero;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.17..
 */
@Module(includes = {
        AbilityModule.class
})
public class CarModule {

    @Provides
    @Singleton
    public TheDoubleZero provideTheDoubleZero(TopCarEngine topCarEngine, RocketPowering ability) {
        TheDoubleZero the00 = new TheDoubleZero(topCarEngine, ability);
        return the00;
    }

    @Provides
    @Singleton
    public BoulderMobile provideBoulderMobile(WeakCarEngine weakCarEngine, ReconstructCar ability) {
        BoulderMobile boulderMobile = new BoulderMobile(weakCarEngine, ability);
        return boulderMobile;
    }


}
