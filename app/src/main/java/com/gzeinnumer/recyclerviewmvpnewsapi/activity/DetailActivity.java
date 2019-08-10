package com.gzeinnumer.recyclerviewmvpnewsapi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gzeinnumer.recyclerviewmvpnewsapi.R;
import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;
import com.gzeinnumer.recyclerviewmvpnewsapi.model.Source;

public class DetailActivity extends AppCompatActivity {

    //todo 19
    public static final String DATA = "data";
    public static final String DATAS = "datas";
    private ArticlesItem articlesItem;
    private Source source;


    //todo 21
    TextView tvTitle, tvSource, tvAuthor, tvPubl, tvDesc, tvCont;
    Button btnUrl;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //todo 20
        articlesItem  = getIntent().getParcelableExtra(DATA);
        source  = getIntent().getParcelableExtra(DATAS);
        //todo 21
        initView();
        initDataToView();
    }


    //todo 22
    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        tvSource = findViewById(R.id.tv_source);
        tvAuthor = findViewById(R.id.tv_author);
        tvPubl = findViewById(R.id.tv_publ);
        tvDesc = findViewById(R.id.tv_desc);
        tvCont = findViewById(R.id.tv_content);
        btnUrl = findViewById(R.id.tv_url);
        img = findViewById(R.id.img);
    }


    //todo 23
    @SuppressLint("SetTextI18n")
    private void initDataToView() {
        Glide.with(DetailActivity.this).load(articlesItem.getUrlToImage()).into(img);
        tvTitle.setText(articlesItem.getTitle());
        tvSource.setText(getString(R.string.source)+source.getName());
        tvAuthor.setText(getString(R.string.aut)+articlesItem.getAuthor());
        tvPubl.setText(getString(R.string.publ)+articlesItem.getPublishedAt());
        tvDesc.setText(articlesItem.getDescription());
        tvCont.setText(articlesItem.getContent());
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = articlesItem.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
