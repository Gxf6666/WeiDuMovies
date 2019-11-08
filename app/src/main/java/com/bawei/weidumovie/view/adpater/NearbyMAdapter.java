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
import com.bawei.weidumovie.model.bean.Nearby;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class NearbyMAdapter extends RecyclerView.Adapter<NearbyMAdapter.MyViewHolder> {
    private List<Nearby> list;
    private Context context;

    public NearbyMAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void addAll(List<Nearby> data){
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
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(list.get(i).logo).into(myViewHolder.iv);
        myViewHolder.name.setText(list.get(i).name);
        myViewHolder.site.setText(list.get(i).address);
        myViewHolder.qm.setText(list.get(i).distance+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
         ImageView iv;
         TextView name;

         TextView site,qm;

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
             iv = itemView.findViewById(R.id.end_iv);
             name = itemView.findViewById(R.id.end_name);
             site = itemView.findViewById(R.id.end_site);
             qm = itemView.findViewById(R.id.end_qm);
         }
     }
}
