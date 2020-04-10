package com.chameapp.giphyclientcleanbylayers.ui.contract;

import com.chameapp.giphyclientcleanbylayers.model.ItemModel;

import java.util.Collection;

public interface UserListView extends LoadDataView {

    void renderUserList(Collection<ItemModel> userModelCollection);

    void viewUser(ItemModel userModel);
}
