package com.chameapp.giphyclientcleanbylayers.di.components;

import android.app.Activity;

import com.chameapp.giphyclientcleanbylayers.di.annotations.PerActivity;
import com.chameapp.giphyclientcleanbylayers.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    Activity activity();
}
