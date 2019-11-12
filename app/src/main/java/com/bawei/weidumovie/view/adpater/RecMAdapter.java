package com.bawei.weidumovie.view.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Recommend;
import com.bawei.weidumovie.presenter.RecommendPresenter;
import com.bawei.weidumovie.view.activity.InForActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class RecMAdapter extends RecyclerView.Adapter<RecMAdapter.MyViewHolder> {
    private List<Recommend> list;
    private Context context;


    public RecMAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<Recommend> data){
        if (data != null) {
             list.addAll(data);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Glide.with(context).load(list.get(i).logo).into(myViewHolder.iv);
        myViewHolder.name.setText(list.get(i).name);
        myViewHolder.site.setText(list.get(i).address);


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

          ImageView iv;
          TextView name;

          TextView site;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.end_iv);
            name = itemView.findViewById(R.id.end_name);
            site = itemView.findViewById(R.id.end_site);
        }
    }

}
