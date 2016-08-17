package org.tek.geza.wackyracers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.tek.geza.wackyracers.di.CarComponent;
import org.tek.geza.wackyracers.di.CarModule;
import org.tek.geza.wackyracers.di.DaggerCarComponent;
import org.tek.geza.wackyracers.racers.TheDoubleZero;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TheDoubleZero theDoubleZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent component = DaggerCarComponent.builder()
                .carModule(new CarModule())
                .build();
        component.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        theDoubleZero.useAbility();
    }
}
