package com.chameapp.giphyclientcleanbylayers.di.components;

import android.content.Context;

import com.chameapp.data.di.modules.ApiModule;
import com.chameapp.domain.repository.Repository;
import com.chameapp.giphyclientcleanbylayers.di.modules.ApplicationModule;
import com.chameapp.giphyclientcleanbylayers.ui.base.BaseActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, ApiModule.class })
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    Repository repository();
}