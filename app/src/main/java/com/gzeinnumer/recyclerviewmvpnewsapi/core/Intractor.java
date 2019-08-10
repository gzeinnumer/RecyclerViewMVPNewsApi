package com.gzeinnumer.recyclerviewmvpnewsapi.core;

import android.content.Context;
import android.util.Log;

import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;
import com.gzeinnumer.recyclerviewmvpnewsapi.model.ResponseNews;
import com.gzeinnumer.recyclerviewmvpnewsapi.server.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intractor implements GetDataNews.Interactor {
    private GetDataNews.onGetDataListener onGetDataListener;
    List<ArticlesItem> listNews = new ArrayList<>();

    public Intractor(GetDataNews.onGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;  //todo 8 yang dibawa todo5
    }


    @Override
    public void initRetrofitCall(Context context, String url1, String url2) {
        RetroServer.getInstance().getBerita(url1, url2).enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.body().getArticles().size()>0){
                    listNews= response.body().getArticles();
                    Log.d("Data", "Refreshed");
                    onGetDataListener.onSuccess("List Size"+listNews.size(), listNews);//todo 9 bawa value ke todo10
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Log.v("Error", t.getMessage());
                onGetDataListener.onFailure(t.getMessage());//todo 9 bawa value ke todo10
            }
        });
    }
}
