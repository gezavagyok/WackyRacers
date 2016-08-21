package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.engine.AverageCarEngine;
import org.tek.geza.wackyracers.engine.TopCarEngine;
import org.tek.geza.wackyracers.engine.WeakCarEngine;

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

    @Provides
    WeakCarEngine provideWeakCarEngine() {
        return new WeakCarEngine(0, 5.0, 100, 0, 60);
    }

    @Provides
    AverageCarEngine provideAverageCarEngine() {
        return new AverageCarEngine(0, 7.0, 100, 0, 60);
    }
}
