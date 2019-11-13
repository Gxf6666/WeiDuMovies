package com.bawei.weidumovie.view.fragment_more;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.Request;

import com.bawei.weidumovie.presenter.MoreRmPresenter;


import com.bawei.weidumovie.view.adpater.MoreMAdapter;
import com.bawei.weidumovie.view.consion.DataCall;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class Fragment_Morerm extends Fragment {

    private MoreRmPresenter moreRmPresenter;
    private XRecyclerView morerm_xlv;
    private int page = 1;
    private MoreMAdapter moreMAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_morerm, null);
     initView(view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        morerm_xlv.setLayoutManager(linearLayoutManager);
        moreMAdapter = new MoreMAdapter(getContext());
        morerm_xlv.setAdapter(moreMAdapter);
        moreRmPresenter = new MoreRmPresenter(new MoreRmPresen());
        moreRmPresenter.Request(1, 5);
        morerm_xlv.setLoadingMoreEnabled(true);
        morerm_xlv.setPullRefreshEnabled(true);
        morerm_xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                moreRmPresenter.Request(page, 5);
                morerm_xlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                moreRmPresenter.Request(page, 5);
                morerm_xlv.loadMoreComplete();
            }
        });

        return view;
    }

    private void initView(View view) {
        morerm_xlv = view.findViewById(R.id.morerm_xlv);
    }


    private class MoreRmPresen implements DataCall<List<Home>> {
        @Override
        public void Success(List<Home> data) {
            moreMAdapter.addAll(data);

            moreMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
