package com.bawei.weidumovie.view.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.QuYuQuery;
import com.bawei.weidumovie.view.activity.InForActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class QuYuQueryMAdapter extends RecyclerView.Adapter<QuYuQueryMAdapter.MyViewHolder> {
    private List<QuYuQuery> list;
    private Context context;

    public QuYuQueryMAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void clear() {
        list.clear();
    }
    public void addAll(List<QuYuQuery> data){
        if (data != null) {
             list.addAll(data);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quyu,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.quyu.setText(list.get(i).name);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = list.get(i).id;
                Intent intent = new Intent(context, InForActivity.class);
                intent.putExtra("Id",Id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
         TextView quyu;
         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
             quyu = itemView.findViewById(R.id.quyu_tv);
         }
     }
}
