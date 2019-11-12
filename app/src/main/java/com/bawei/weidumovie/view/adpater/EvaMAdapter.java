package com.bawei.weidumovie.view.adpater;

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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class EvaMAdapter extends RecyclerView.Adapter<EvaMAdapter.MyViewHolder> {


    private List<Evaluate> list;
    private Context context;

    public EvaMAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Evaluate> data){
        if (data != null) {
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pingjia, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).commentHeadPic)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(myViewHolder.iv);
        myViewHolder.pj_tv.setText(list.get(i).commentUserNam);
        SimpleDateFormat df = new SimpleDateFormat("MM-dd   HH:mm");
        String format = df.format(list.get(i).commentTime);
        myViewHolder.pj_time.setText(format);
        myViewHolder.movie_evaluate.setText(list.get(i).commentContent);
        myViewHolder.pj_num.setText(list.get(i).greatNum+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

         TextView pj_tv,pj_time,movie_evaluate,pj_num;
         ImageView iv;

         public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.pj_iv);
            pj_tv = itemView.findViewById(R.id.pj_tv);
             pj_time = itemView.findViewById(R.id.pj_time);
             movie_evaluate = itemView.findViewById(R.id.movie_evaluate);
             pj_num = itemView.findViewById(R.id.pj_num);
         }
    }
}
