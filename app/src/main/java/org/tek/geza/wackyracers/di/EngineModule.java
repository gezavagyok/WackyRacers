package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.engine.TopCarEngine;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.17..
 */
@Module
public class EngineModule {

    @Provides
    TopCarEngine provideTopCarEngine(){
        return new TopCarEngine(0,8.5,100,0,100);
    }
}
