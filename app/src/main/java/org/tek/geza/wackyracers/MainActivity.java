package org.tek.geza.wackyracers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.tek.geza.wackyracers.di.CarComponent;
import org.tek.geza.wackyracers.di.CarModule;
import org.tek.geza.wackyracers.di.DaggerCarComponent;
import org.tek.geza.wackyracers.racers.TheDoubleZero;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    TheDoubleZero theDoubleZero;

    @BindView(R.id.display)
    TextView display;

    @OnClick(R.id.testButton)
    public void onAbilityButtonClicked() {
        theDoubleZero.useAbility()
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
