package com.chameapp.domain.repository;

import com.chameapp.domain.model.DomainItem;

import java.util.List;
import io.reactivex.Observable;

public interface Repository {
    Observable<List<DomainItem>> getDataFromMemory();

    Observable<List<DomainItem>> getDataFromNetwork();

    Observable<List<DomainItem>> getData();
}