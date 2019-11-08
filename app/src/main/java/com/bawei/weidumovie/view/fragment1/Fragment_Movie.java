package com.bawei.weidumovie.view.fragment1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Recommend;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.RecommendPresenter;
import com.bawei.weidumovie.view.adpater.RecMAdapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class Fragment_Movie extends Fragment {

    private RecyclerView rlv;
    private RecommendPresenter recommendPresenter;
    private RecMAdapter recMAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.movie_recommend,null);
        rlv = view.findViewById(R.id.rlv);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv.setLayoutManager(linearLayoutManager);
        recMAdapter = new RecMAdapter(getContext());
        rlv.setAdapter(recMAdapter);
        recommendPresenter = new RecommendPresenter(new RecommendPresen());
        recommendPresenter.Request(1,5);
        return view;

    }

    private class RecommendPresen implements DataCall<List<Recommend>> {
        @Override
        public void Success(List<Recommend> data) {
                recMAdapter.addAll(data);

                recMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
