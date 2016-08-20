package org.tek.geza.wackyracers.di;

import org.tek.geza.wackyracers.abilities.concrete_abilities.ReconstructCar;
import org.tek.geza.wackyracers.abilities.concrete_abilities.RocketPowering;
import org.tek.geza.wackyracers.effect.RepairEffect;
import org.tek.geza.wackyracers.effect.RocketEffect;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geza on 2016.08.18..
 */
@Module(includes = {
        EffectModule.class
})
public class AbilityModule {
    @Provides
    RocketPowering provideRocketPowering(RocketEffect rocketEffect) {
        return new RocketPowering(rocketEffect);
    }

    @Provides
    ReconstructCar provideReconstructCar(RepairEffect effect) {
        return new ReconstructCar(effect);
    }
}
