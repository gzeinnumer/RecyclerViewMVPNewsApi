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

//todo 15 implements
public class MainActivity extends AppCompatActivity implements GetDataNews.View{

    //todo 2
    RecyclerView recyclerView;
    //todo 12
    private Presenter presenter;
    AdapterNews adapterNews;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo 3
        recyclerView = findViewById(R.id.rv);
        //todo 13
        initObject();
    }

    //todo 14
    private void initObject() {
        presenter = new Presenter(this);
        presenter.getDataFromURL(getApplicationContext(), "us","e5430ac2a413408aaafdf60bfa27a874");
        linearLayoutManager = new LinearLayoutManager(this);
    }

    //todo 16
    @Override
    public void onGetDataSuccess(String message, List<ArticlesItem> list) {
        adapterNews = new AdapterNews(getApplicationContext(), list);
        recyclerView.setAdapter(adapterNews);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    //todo 17
    @Override
    public void onGetDataFailure(String message) {
        Log.d("status", message);
    }
}
