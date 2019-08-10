package com.gzeinnumer.recyclerviewmvpnewsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gzeinnumer.recyclerviewmvpnewsapi.R;
import com.gzeinnumer.recyclerviewmvpnewsapi.activity.DetailActivity;
import com.gzeinnumer.recyclerviewmvpnewsapi.model.ArticlesItem;

import java.util.List;
public class AdapterNews extends RecyclerView.Adapter<AdapterNews.MyHolder> {
    private Context context;
    private List<ArticlesItem> list;

    public AdapterNews(Context context, List<ArticlesItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.DATA, list.get(position));
                intent.putExtra(DetailActivity.DATAS, list.get(position).getSource());
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(list.get(position).getUrlToImage()).into(holder.img);
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv);
            textView = itemView.findViewById(R.id.title_item);
            img = itemView.findViewById(R.id.img_item);
        }
    }
}
