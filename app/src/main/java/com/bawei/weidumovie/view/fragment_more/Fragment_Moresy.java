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
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.MoreSyPresenter;
import com.bawei.weidumovie.view.adpater.HomeMAdapter1;
import com.bawei.weidumovie.view.consion.DataCall;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class Fragment_Moresy extends Fragment {
    private XRecyclerView moresy_xlv;
    private HomeMAdapter1 homeMAdapter1;
    private MoreSyPresenter moreRmPresenter;
    private int page = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_moresy, null);
        initView(view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        moresy_xlv.setLayoutManager(linearLayoutManager);
        homeMAdapter1 = new HomeMAdapter1(getContext());
        moresy_xlv.setAdapter(homeMAdapter1);
        moreRmPresenter = new MoreSyPresenter(new MoreSyPresen());
        moreRmPresenter.Request(1, 5);
        moresy_xlv.setLoadingMoreEnabled(true);
        moresy_xlv.setPullRefreshEnabled(true);
        moresy_xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                moreRmPresenter.Request(page, 5);
                moresy_xlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                moreRmPresenter.Request(page, 5);
                moresy_xlv.loadMoreComplete();
            }
        });
        return view;
    }

    private void initView(View view) {

        moresy_xlv = (XRecyclerView) view.findViewById(R.id.moresy_xlv);
    }

    private class MoreSyPresen implements DataCall<List<HomeOne>> {
        @Override
        public void Success(List<HomeOne> data) {
            homeMAdapter1.addAllOne(data);

            homeMAdapter1.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
