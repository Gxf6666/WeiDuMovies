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

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.view.activity.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class MoreMAdapter extends RecyclerView.Adapter<MoreMAdapter.MyViewHolder>  {
    private ArrayList<Home> list = new ArrayList<>();
    private Context context;

    public MoreMAdapter(Context context) {
        this.context = context;
    }


    public void addAll(List<Home> data) {
        if (list != null) {
            list.addAll(data);
        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_more, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.more_iv);
        myViewHolder.more_tv_name.setText(list.get(i).name);
        myViewHolder.more_tv_daoyan.setText(list.get(i).director);
        myViewHolder.more_tv_daoyan.setText(list.get(i).starring);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView more_tv_name;
        ImageView more_iv;
        TextView more_tv_zhuyan;
        TextView more_tv_daoyan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            more_iv = itemView.findViewById(R.id.more_iv);
            more_tv_name = itemView.findViewById(R.id.more_tv_name);
            more_tv_zhuyan = itemView.findViewById(R.id.more_tv_zhuyan);
            more_tv_daoyan = itemView.findViewById(R.id.more_tv_daoyan);

        }

    }
}
