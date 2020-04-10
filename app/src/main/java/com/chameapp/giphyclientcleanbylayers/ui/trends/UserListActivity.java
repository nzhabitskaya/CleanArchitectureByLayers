package com.chameapp.giphyclientcleanbylayers.ui.trends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.chameapp.giphyclientcleanbylayers.R;
import com.chameapp.giphyclientcleanbylayers.di.components.DaggerUserComponent;
import com.chameapp.giphyclientcleanbylayers.di.components.UserComponent;
import com.chameapp.giphyclientcleanbylayers.model.ItemModel;
import com.chameapp.giphyclientcleanbylayers.ui.base.BaseActivity;
import com.chameapp.giphyclientcleanbylayers.ui.contract.HasComponent;

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>, UserListFragment.UserListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    @Override
    public void onUserClicked(ItemModel userModel) {
        //this.navigator.navigateToUserDetails(this, userModel.getUserId());
    }
}
