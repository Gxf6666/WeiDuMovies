package com.bawei.weidumovie.view.adpater;
/*时间:2019/11/13 0013
创建人:郭学飞*/


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.MovieDirec;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder>{
    private List<String> list;
    private Context context;

    public PhotoAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, null);
        return new PhotoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.MyViewHolder myViewHolder, int i) {
       Glide.with(context).load(list.get(i)).error(R.mipmap.ky).into(myViewHolder.photo_sdv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView photo_sdv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photo_sdv  = itemView.findViewById(R.id.photo_sdv);
        }
    }
}
