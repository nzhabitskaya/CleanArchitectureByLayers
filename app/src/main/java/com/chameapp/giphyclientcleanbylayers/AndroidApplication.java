package com.chameapp.giphyclientcleanbylayers;

import android.app.Application;

import com.chameapp.giphyclientcleanbylayers.di.components.ApplicationComponent;
import com.chameapp.giphyclientcleanbylayers.di.components.DaggerApplicationComponent;
import com.chameapp.giphyclientcleanbylayers.di.modules.ApplicationModule;

/**
 * @author Natallia Zhabitskaya <natallia_zhabitskaya1@epam.com>
 */

public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}