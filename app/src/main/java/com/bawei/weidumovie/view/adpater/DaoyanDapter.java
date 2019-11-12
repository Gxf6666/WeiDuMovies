package com.bawei.weidumovie.view.adpater;
/*时间:2019/11/12 0012
创建人:郭学飞*/


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Evaluate;
import com.bawei.weidumovie.model.bean.MovieDirec;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoyanDapter extends RecyclerView.Adapter<DaoyanDapter.MyViewHolder>{

    private List<MovieDirec> list;
    private Context context;

    public DaoyanDapter(List<MovieDirec> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DaoyanDapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_director, null);
        return new DaoyanDapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaoyanDapter.MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).photo)
                .into(myViewHolder.item_iv_daoyan_photo);
        myViewHolder.item_tv_daoyan_score.setText(list.get(i).name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item_tv_daoyan_score;
        ImageView item_iv_daoyan_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv_daoyan_score = itemView.findViewById(R.id.item_tv_daoyan_score);
            item_iv_daoyan_photo = itemView.findViewById(R.id.item_iv_daoyan_photo);
        }
    }
}
