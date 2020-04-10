package com.chameapp.giphyclientcleanbylayers.presenter;

import android.support.annotation.NonNull;

import com.chameapp.domain.interactor.DefaultObserver;
import com.chameapp.domain.interactor.GetTrendsUseCase;
import com.chameapp.domain.model.DomainItem;
import com.chameapp.giphyclientcleanbylayers.di.annotations.PerActivity;
import com.chameapp.giphyclientcleanbylayers.model.ItemModel;
import com.chameapp.giphyclientcleanbylayers.model.mapper.ItemModelDataMapper;
import com.chameapp.giphyclientcleanbylayers.ui.contract.UserListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class TrendsPresenter implements Presenter {

    private UserListView viewListView;

    private final GetTrendsUseCase getTrendsUseCase;
    private final ItemModelDataMapper userModelDataMapper;

    @Inject
    public TrendsPresenter(GetTrendsUseCase getUserListUserCase,
                           ItemModelDataMapper userModelDataMapper) {
        this.getTrendsUseCase = getUserListUserCase;
        this.userModelDataMapper = userModelDataMapper;
    }

    public void setView(@NonNull UserListView view) {
        this.viewListView = view;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {
        this.getTrendsUseCase.dispose();
        this.viewListView = null;
    }

    /**
     * Initializes the presenter by start retrieving the user list.
     */
    public void initialize() {
        this.loadUserList();
    }

    /**
     * Loads all users.
     */
    private void loadUserList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getUserList();
    }

    public void onUserClicked(ItemModel userModel) {
        this.viewListView.viewUser(userModel);
    }

    private void showViewLoading() {
        this.viewListView.showLoading();
    }

    private void hideViewLoading() {
        this.viewListView.hideLoading();
    }

    private void showViewRetry() {
        this.viewListView.showRetry();
    }

    private void hideViewRetry() {
        this.viewListView.hideRetry();
    }

    private void showUsersCollectionInView(Collection<DomainItem> usersCollection) {
        final Collection<ItemModel> userModelsCollection =
                this.userModelDataMapper.transform(usersCollection);
        this.viewListView.renderUserList(userModelsCollection);
    }

    private void getUserList() {
        this.getTrendsUseCase.execute(new UserListObserver());
    }

    private final class UserListObserver extends DefaultObserver<List<DomainItem>> {

        @Override
        public void onComplete() {
            TrendsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            TrendsPresenter.this.hideViewLoading();
            //TrendsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            TrendsPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<DomainItem> users) {
            TrendsPresenter.this.showUsersCollectionInView(users);
        }
    }
}
