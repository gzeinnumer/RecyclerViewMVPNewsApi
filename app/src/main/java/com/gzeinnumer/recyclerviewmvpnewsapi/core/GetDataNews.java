package com.gzeinnumer.recyclerviewmvpnewsapi.core;

import android.content.Context;

import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;

import java.util.List;

public interface GetDataNews {
    interface View{
        void onGetDataSuccess(String message, List<ArticlesItem> list);
        void onGetDataFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url1, String url2);
    }
    interface Interactor{
        void initRetrofitCall(Context context, String url1, String url2);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<ArticlesItem> list);
        void onFailure(String message);
    }
}
