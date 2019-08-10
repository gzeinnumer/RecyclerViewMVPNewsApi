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

//todo 8
public class Intractor implements GetDataNews.Interactor {
    private GetDataNews.onGetDataListener onGetDataListener;
    List<ArticlesItem> listNews = new ArrayList<>();
    List<String> titleNews = new ArrayList<>();

    public Intractor(GetDataNews.onGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
    }


    @Override
    public void initRetrofitCall(Context context, String url1, String url2) {
        RetroServer.getInstance().getBerita(url1, url2).enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.body().getArticles().size()>0){
                    listNews= response.body().getArticles();
                    for (int i=0; i<listNews.size(); i++){
                        titleNews.add(listNews.get(i).getTitle());
                    }
                    Log.d("Data", "Refreshed");
                    onGetDataListener.onSuccess("List Size"+titleNews.size(), listNews);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Log.v("Error", t.getMessage());
                onGetDataListener.onFailure(t.getMessage());
            }
        });
    }
}
