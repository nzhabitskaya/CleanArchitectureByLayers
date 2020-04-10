package com.chameapp.domain.interactor;

import com.chameapp.domain.model.DomainItem;
import com.chameapp.domain.repository.Repository;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

public class GetTrendsUseCase extends UseCase<List<DomainItem>> {

    private final Repository repository;

    @Inject
    GetTrendsUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    Observable<List<DomainItem>> buildUseCaseObservable() {
        return this.repository.getData();
    }
}
