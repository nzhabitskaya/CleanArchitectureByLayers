package com.chameapp.data.repository;

import com.chameapp.data.entities.mapper.ItemEntityDataMapper;
import com.chameapp.data.network.api.GetTrendsService;
import com.chameapp.domain.model.DomainItem;
import com.chameapp.domain.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;

@Singleton
public class TrendsRepository implements Repository {

    private GetTrendsService getTrendsService;
    private List<DomainItem> cache;
    private final ItemEntityDataMapper mapper;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    @Inject
    public TrendsRepository(GetTrendsService getTrendsService, ItemEntityDataMapper mapper) {
        this.mapper = mapper;
        this.getTrendsService = getTrendsService;
        cache = new ArrayList<>();
        timestamp = System.currentTimeMillis();

    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<List<DomainItem>> getDataFromMemory() {
        if (isUpToDate()) {
            return Observable.fromArray(cache);
        } else {
            timestamp = System.currentTimeMillis();
            cache.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<List<DomainItem>> getDataFromNetwork() {

        return getTrendsService.getTrends(5, 0)
                .map(mapper::transformTrends);

        /*Observable<TopRated> topRatedObservable = movieService.getTopRatedMovies(1).concatWith(movieService.getTopRatedMovies(2)).concatWith(movieService.getTopRatedMovies(3));

        return topRatedObservable.concatMap(new Function<TopRated, Observable<Result>>() {
            @Override
            public Observable<ItemsResponse> apply(@NonNull TopRated topRated) throws Exception {
                return Observable.fromIterable(topRated.results);
            }
        }).doOnNext(result -> results.add(result));*/
    }

    @Override
    public Observable<List<DomainItem>> getData() {
        return getDataFromNetwork();
        //return getDataFromMemory().switchIfEmpty(getDataFromNetwork());
    }
}
