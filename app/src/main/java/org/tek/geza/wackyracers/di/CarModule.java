package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.concrete_abilities.ReconstructCar;
import org.tek.geza.wackyracers.abilities.concrete_abilities.RocketPowering;
import org.tek.geza.wackyracers.abilities.concrete_abilities.SummonBats;
import org.tek.geza.wackyracers.engine.AverageCarEngine;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.WeakCarEngine;
import org.tek.geza.wackyracers.racers.BoulderMobile01;
import org.tek.geza.wackyracers.racers.CreepyCoupe02;
import org.tek.geza.wackyracers.racers.TheMeanMachine00;

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
    public TheMeanMachine00 provideTheDoubleZero(TopCarEngine topCarEngine, RocketPowering ability) {
        TheMeanMachine00 the00 = new TheMeanMachine00(topCarEngine, ability);
        return the00;
    }

    @Provides
    @Singleton
    public BoulderMobile01 provideBoulderMobile(WeakCarEngine weakCarEngine, ReconstructCar ability) {
        BoulderMobile01 boulderMobile01 = new BoulderMobile01(weakCarEngine, ability);
        return boulderMobile01;
    }

    @Provides
    @Singleton
    public CreepyCoupe02 provideCreepyCoupe02(AverageCarEngine averageCarEnginem, SummonBats ability) {
        CreepyCoupe02 creepyCoupe02 = new CreepyCoupe02(averageCarEnginem, ability);
        return creepyCoupe02;
    }


}
