package com.chameapp.giphyclientcleanbylayers.di.modules;

import android.content.Context;
import com.chameapp.giphyclientcleanbylayers.AndroidApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}