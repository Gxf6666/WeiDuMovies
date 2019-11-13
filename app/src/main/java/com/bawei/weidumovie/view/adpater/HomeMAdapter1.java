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
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.view.activity.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class HomeMAdapter1 extends RecyclerView.Adapter<HomeMAdapter1.MyViewHolder> {

    private List<HomeOne> list = new ArrayList<>();
    private Context context;

    public HomeMAdapter1(Context context) {
        this.context = context;
    }

    public void addAllOne(List<HomeOne> data1){
        if (data1 != null) {
             list.addAll(data1);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home1, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {
        Glide.with(context).load(list.get(i).imageUrl).into(myViewHolder.iv);
        myViewHolder.releasedmovie_tv_name.setText(list.get(i).name);
        SimpleDateFormat format = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "日上映");
        String Time = format.format(list.get(i).releaseTime);
        myViewHolder.releasedmovie_tv_time.setText(Time);
        myViewHolder.releasedmovie_tv_usernum.setText(list.get(i).wantSeeNum+"");
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

        TextView releasedmovie_tv_time,releasedmovie_tv_usernum;
        ImageView iv;
        TextView releasedmovie_tv_name;
        Button releasedmovie_bt,reservation_bt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.releasedmovie_iv);
            releasedmovie_tv_name = itemView.findViewById(R.id.releasedmovie_tv_name);
            releasedmovie_tv_time = itemView.findViewById(R.id.releasedmovie_tv_time);
            releasedmovie_tv_usernum = itemView.findViewById(R.id.releasedmovie_tv_usernum);
            releasedmovie_bt = itemView.findViewById(R.id.releasedmovie_bt);
            reservation_bt = itemView.findViewById(R.id.reservation_bt);
        }
    }
}
