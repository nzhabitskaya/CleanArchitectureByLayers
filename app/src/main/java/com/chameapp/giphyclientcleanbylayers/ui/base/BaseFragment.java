package com.chameapp.giphyclientcleanbylayers.ui.base;

import android.app.Fragment;
import android.widget.Toast;

import com.chameapp.giphyclientcleanbylayers.ui.contract.HasComponent;

public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
