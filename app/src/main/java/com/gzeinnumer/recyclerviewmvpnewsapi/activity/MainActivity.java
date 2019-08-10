package com.gzeinnumer.recyclerviewmvpnewsapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.gzeinnumer.recyclerviewmvpnewsapi.R;
import com.gzeinnumer.recyclerviewmvpnewsapi.adapter.AdapterNews;
import com.gzeinnumer.recyclerviewmvpnewsapi.core.GetDataNews;
import com.gzeinnumer.recyclerviewmvpnewsapi.core.Presenter;
import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetDataNews.View{

    RecyclerView recyclerView;
    private Presenter presenter;//todo 1
    AdapterNews adapterNews;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        initObject();
    }

    private void initObject() {
        presenter = new Presenter(this);//todo 2 membawa MainActivity dan GetDataNews.View
        presenter.getDataFromURL(getApplicationContext(), "us","e5430ac2a413408aaafdf60bfa27a874");//todo 3 pakai funsi ini yang di implementkan Presenter
        linearLayoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void onGetDataSuccess(String message, List<ArticlesItem> list) { //todo 12 params di bawa oleh todo 11
        adapterNews = new AdapterNews(getApplicationContext(), list); //todo 13 silahkan pakai data
        recyclerView.setAdapter(adapterNews);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataFailure(String message) {//todo 12 params di bawa oleh todo 11
        Log.d("status", message);//todo 13 silahkan pakai data
    }
}
