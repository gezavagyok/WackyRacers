package org.tek.geza.wackyracers.abilities;

import org.tek.geza.wackyracers.Effect;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketPowering extends CooldownAbility {

    @Inject
    public RocketPowering() {
        super(120.0);
    }

    @Override
    public Observable<Effect> execute() {
        return Observable.create(subscriber -> {
            if(isAbilityReady()) {
                Effect rocketEffect = new Effect(100.0, // +100% acceleration
                        0, // no damage has been done
                        -50.0, // with great power comes great consumption...
                        200, // only accerlates
                        100, // + 100 max speed
                        4 // for 4 seconds
                );
                rocketEffect.setName("Rocket Powered");
                subscriber.onStart();
                subscriber.onNext(rocketEffect);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new CooldownLeftException("Ability ready in: "+timeLeft()+"s"));
            }
        });
    }

    @Override
    public String getName() {
        return "Rocket Powered";
    }
}
