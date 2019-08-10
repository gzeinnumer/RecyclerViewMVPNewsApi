package com.gzeinnumer.recyclerviewmvpnewsapi.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//todo 5
public class RetroServer {
    private static final String base_url = "https://newsapi.org/v2/";

    private static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}
