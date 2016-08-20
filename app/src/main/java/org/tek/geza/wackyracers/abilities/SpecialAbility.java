package org.tek.geza.wackyracers.abilities;

import org.tek.geza.wackyracers.effect.Effect;

import rx.Observable;

/**
 * Created by geza on 2016.08.17..
 */

public interface SpecialAbility {
    Observable<Effect> execute();
    String getName();
}
