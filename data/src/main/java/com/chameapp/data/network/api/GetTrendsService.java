package com.chameapp.data.network.api;

import com.chameapp.data.entities.pojos.Trends;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetTrendsService {

    @GET("trending")
    Observable<Trends> getTrends(@Query("limit") int limit, @Query("offset") int offset);
}