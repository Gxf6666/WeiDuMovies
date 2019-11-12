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
import com.bawei.weidumovie.model.bean.MovieActor;
import com.bawei.weidumovie.model.bean.MovieDirec;
import com.bumptech.glide.Glide;

import java.util.List;

public class YanyuanDapter extends RecyclerView.Adapter<YanyuanDapter.MyViewHolder>{

    private List<MovieActor> list;
    private Context context;

    public YanyuanDapter(List<MovieActor> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public YanyuanDapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_actor, null);
        return new YanyuanDapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YanyuanDapter.MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).photo)
                .into(myViewHolder.item_iv_yanyuan_photo);
        myViewHolder.item_tv_yanyuan_score.setText(list.get(i).name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item_tv_yanyuan_score;
        ImageView item_iv_yanyuan_photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv_yanyuan_score = itemView.findViewById(R.id.item_tv_yanyuan_score);
            item_iv_yanyuan_photo = itemView.findViewById(R.id.item_iv_yanyuan_photo);
        }
    }
}
