package org.tek.geza.wackyracers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.tek.geza.wackyracers.di.CarComponent;
import org.tek.geza.wackyracers.di.CarModule;
import org.tek.geza.wackyracers.di.DaggerCarComponent;
import org.tek.geza.wackyracers.effect.Effect;
import org.tek.geza.wackyracers.racers.BoulderMobile01;
import org.tek.geza.wackyracers.racers.CreepyCoupe02;
import org.tek.geza.wackyracers.racers.TheMeanMachine00;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    TheMeanMachine00 theMeanMachine00;

    @Inject
    BoulderMobile01 boulderMobile01;

    @Inject
    CreepyCoupe02 creepyCoupe02;

    @BindView(R.id.display)
    TextView display;

    @OnClick(R.id.testButton)
    public void onAbilityButtonClicked() {
        theMeanMachine00.useAbility()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> display.setText("used"))
                .onErrorReturn(throwable -> {
                    display.setText(throwable.getMessage());
                    return Effect.error();
                })
                .subscribe();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent component = DaggerCarComponent.builder()
                .carModule(new CarModule())
                .build();
        component.inject(this);
        ButterKnife.bind(this);
    }
}
