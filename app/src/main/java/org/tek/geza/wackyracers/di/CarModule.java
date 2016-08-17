package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.racers.DefaultConfiguration;
import org.tek.geza.wackyracers.racers.TheDoubleZero;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.17..
 */
@Module
public class CarModule {

    @Provides
    @Singleton
    public TheDoubleZero provideTheDoubleZero(){
        TheDoubleZero the00 = new TheDoubleZero();
        the00.setAcceleration(8.5);     // m/s
        the00.setCurrentSpeed(0);       // waiting for the start
        the00.setDamaged(0);            // 0-100, 0 - no damage at all, 100 - game over
        the00.setFuel(100);             // percent
        the00.setMaxSpeed(100);         // km/h

        the00.setDefaultConfiguration(new DefaultConfiguration(100,0,8.5,0,100));
        return the00;
    }


}
