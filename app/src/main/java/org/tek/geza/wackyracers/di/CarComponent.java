package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by geza on 2016.08.17..
 */
@Singleton
@Component(modules = CarModule.class)
public interface CarComponent {
    void inject(MainActivity activity);
}
