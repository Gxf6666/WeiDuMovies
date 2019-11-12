package com.bawei.weidumovie.view.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.QuYu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class QuYuMAdapter extends RecyclerView.Adapter<QuYuMAdapter.MyViewHolder> {

    private List<QuYu> list;
    private Context context;

    public QuYuMAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

   public void addAll(List<QuYu> data){
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
            myViewHolder.quyu.setText(list.get(i).regionName);

            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    isWork.SetId(list.get(i).regionId);
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
    private IsWork isWork;

    public void setIsWork(IsWork isWork) {
        this.isWork = isWork;
    }

    public interface IsWork{
         void SetId(int Id);
    }
}
