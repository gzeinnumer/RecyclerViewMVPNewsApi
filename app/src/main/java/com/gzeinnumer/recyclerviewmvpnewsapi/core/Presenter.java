package com.gzeinnumer.recyclerviewmvpnewsapi.core;

import android.content.Context;

import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;

import java.util.List;

//todo 9
public class Presenter implements GetDataNews.Presenter, GetDataNews.onGetDataListener{

    private GetDataNews.View mGetDataView;
    private Intractor intractor;

    public Presenter(GetDataNews.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        intractor = new Intractor(this);
    }

    @Override
    public void getDataFromURL(Context context, String url1, String url2) {
        intractor.initRetrofitCall(context, url1, url2);
    }

    @Override
    public void onSuccess(String message, List<ArticlesItem> list) {
        mGetDataView.onGetDataSuccess(message, list);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
