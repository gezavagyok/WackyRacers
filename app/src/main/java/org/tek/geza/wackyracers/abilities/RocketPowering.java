package org.tek.geza.wackyracers.abilities;

import org.tek.geza.wackyracers.Effect;
import org.tek.geza.wackyracers.engine.decorator.AccelerationDecorator;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by geza on 2016.08.17..
 */

public class RocketPowering extends CooldownAbility {

    AccelerationDecorator decorator;

    @Inject
    public RocketPowering(AccelerationDecorator decorator) {
        super(120.0);
        this.decorator = decorator;
    }

    @Override
    public Observable<Effect> execute() {
        return Observable.create(subscriber -> {
            if(isAbilityReady()) {
                Effect rocketEffect = new Effect(decorator);
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
