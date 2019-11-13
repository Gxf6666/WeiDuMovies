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
import com.bawei.weidumovie.presenter.MorePresenter;
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
public class Fragment_More extends Fragment {

    private MorePresenter morePresenter;
    private MoreMAdapter moreMAdapter;
    private XRecyclerView more_xlv;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_more, null);
        initView(view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        more_xlv.setLayoutManager(linearLayoutManager);
        moreMAdapter = new MoreMAdapter(getContext());
        more_xlv.setAdapter(moreMAdapter);
        morePresenter = new MorePresenter(new MorePresen());
        morePresenter.Request(1,5);
        more_xlv.setLoadingMoreEnabled(true);
        more_xlv.setPullRefreshEnabled(true);
        more_xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                morePresenter.Request(page,5);
                more_xlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                morePresenter.Request(page,5);
                more_xlv.loadMoreComplete();
            }
        });


        return view;
    }

    private void initView(View view) {
        more_xlv = (XRecyclerView) view.findViewById(R.id.more_xlv);
    }

    private class MorePresen implements DataCall<List<Home>> {
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
