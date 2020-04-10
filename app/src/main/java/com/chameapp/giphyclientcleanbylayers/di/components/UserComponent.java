package com.chameapp.giphyclientcleanbylayers.di.components;

import com.chameapp.giphyclientcleanbylayers.di.annotations.PerActivity;
import com.chameapp.giphyclientcleanbylayers.di.modules.ActivityModule;
import com.chameapp.giphyclientcleanbylayers.di.modules.UserModule;
import com.chameapp.giphyclientcleanbylayers.ui.trends.UserListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class, UserModule.class })
public interface UserComponent extends ActivityComponent {
    void inject(UserListFragment userListFragment);
}
