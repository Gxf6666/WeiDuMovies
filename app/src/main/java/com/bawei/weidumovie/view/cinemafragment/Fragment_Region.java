package com.bawei.weidumovie.view.cinemafragment;

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
import com.bawei.weidumovie.model.bean.QuYu;
import com.bawei.weidumovie.model.bean.QuYuQuery;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.QuYuPresenter;
import com.bawei.weidumovie.presenter.QuYuQueryPresenter;
import com.bawei.weidumovie.view.adpater.QuYuMAdapter;
import com.bawei.weidumovie.view.adpater.QuYuQueryMAdapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class Fragment_Region extends Fragment {
    private RecyclerView rlv2;
    private RecyclerView rlv3;
    private QuYuPresenter quYuPresenter;
    private QuYuMAdapter quYuMAdapter;
    private QuYuQueryPresenter quYuQueryPresenter;
    private QuYuQueryMAdapter quYuQueryMAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.movie_region, null);
        initView(view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv2.setLayoutManager(linearLayoutManager);
        quYuMAdapter = new QuYuMAdapter(getContext());
        rlv2.setAdapter(quYuMAdapter);
        quYuPresenter = new QuYuPresenter(new QuYuPresen());
        quYuPresenter.Request();
        quYuMAdapter.setIsWork(new QuYuMAdapter.IsWork() {
            @Override
            public void SetId(int Id) {
                quYuQueryPresenter.Request(Id);

            }
        });

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rlv3.setLayoutManager(linearLayoutManager1);
        quYuQueryMAdapter = new QuYuQueryMAdapter(getContext());
        rlv3.setAdapter(quYuQueryMAdapter);
        quYuQueryPresenter = new QuYuQueryPresenter(new QuYuQueryPresen());

        return view;
    }

    private void initView(View view) {
        rlv2 = (RecyclerView) view.findViewById(R.id.rlv2);
        rlv3 = (RecyclerView) view.findViewById(R.id.rlv3);
    }

    private class QuYuPresen implements DataCall<List<QuYu>> {
        @Override
        public void Success(List<QuYu> data) {
            quYuMAdapter.addAll(data);

            quYuMAdapter.notifyDataSetChanged();

        }

        @Override
        public void Error(Request request) {

        }
    }

    private class QuYuQueryPresen implements DataCall<List<QuYuQuery>> {
        @Override
        public void Success(List<QuYuQuery> data) {
                quYuQueryMAdapter.clear();
                quYuQueryMAdapter.addAll(data);

                quYuQueryMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
