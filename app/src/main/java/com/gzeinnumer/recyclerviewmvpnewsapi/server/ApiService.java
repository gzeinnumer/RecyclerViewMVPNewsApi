package com.gzeinnumer.recyclerviewmvpnewsapi.server;

import com.gzeinnumer.recyclerviewmvpnewsapi.model.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//todo 6
public interface ApiService {
    //?country=us&apiKey=e5430ac2a413408aaafdf60bfa27a874
    @GET("top-headlines")
    Call<ResponseNews> getBerita(@Query("country") String country,
                                 @Query("apiKey") String apiKey);
}
