package com.gzeinnumer.recyclerviewmvpnewsapi.core;

import android.content.Context;

import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;

import java.util.List;

public class Presenter implements GetDataNews.Presenter, GetDataNews.onGetDataListener{

    private GetDataNews.View mGetDataView;
    private Intractor intractor;

    public Presenter(GetDataNews.View mGetDataView) {//todo 4
        this.mGetDataView = mGetDataView;
        intractor = new Intractor(this);//todo 5 awa Presenter.this
    }

    @Override
    public void getDataFromURL(Context context, String url1, String url2) { //todo 6 yang dipanggil todo3 tadi
        intractor.initRetrofitCall(context, url1, url2);//todo 7 interactor membawa nya lagi ke fungsi
    }

    @Override
    public void onSuccess(String message, List<ArticlesItem> list) { //todo 10 params bawakw todo 11
        mGetDataView.onGetDataSuccess(message, list); //todo 11. ini terhubung ke Mainactivity, hasil dari todo4
    }

    @Override
    public void onFailure(String message) {//todo 10 params bawa ke todo 11
        mGetDataView.onGetDataFailure(message); //todo 11. ini terhubung ke Mainactovoty, hasil dari todo4
    }
}
