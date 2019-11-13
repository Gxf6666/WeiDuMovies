package com.bawei.weidumovie.view.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.view.activity.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class HomeMAdapter extends RecyclerView.Adapter<HomeMAdapter.MyViewHolder> {
    private ArrayList<Home> list = new ArrayList<>();
    private Context context;

    public HomeMAdapter(Context context) {
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.iv);
        myViewHolder.score_tv.setText(list.get(i).score+"");
        myViewHolder.tv.setText(list.get(i).name);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movieid",list.get(i).movieId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

         TextView tv;
         ImageView iv;
         TextView score_tv;
         TextView hotmovie_bt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.hotmovie_iv);
            score_tv = itemView.findViewById(R.id.score_tv);
            tv = score_tv = itemView.findViewById(R.id.hotmovie_tv);
            hotmovie_bt = itemView.findViewById(R.id.hotmovie_bt);

        }

    }
}
