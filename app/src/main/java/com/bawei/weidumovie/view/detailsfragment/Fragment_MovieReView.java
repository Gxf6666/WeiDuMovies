package com.bawei.weidumovie.view.detailsfragment;

import android.content.Intent;
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
import com.bawei.weidumovie.model.bean.Evaluate;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.EvaluatePresenter;
import com.bawei.weidumovie.view.adpater.EvaMAdapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public class Fragment_MovieReView extends Fragment {


    private RecyclerView evaluate_rlv;
    private EvaluatePresenter evaluatePresenter;
    private EvaMAdapter evaMAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_moviepj, null);
        initView(view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        evaluate_rlv.setLayoutManager(linearLayoutManager);
        evaMAdapter = new EvaMAdapter(getContext());
        evaluate_rlv.setAdapter(evaMAdapter);
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("Id", 0);
        evaluatePresenter = new EvaluatePresenter(new EvaPresen());
        evaluatePresenter.Request(id,1,5);
        return view;
    }


    private void initView(View view) {
        evaluate_rlv = (RecyclerView) view.findViewById(R.id.evaluate_rlv);
    }

    private class EvaPresen implements DataCall<List<Evaluate>> {
        @Override
        public void Success(List<Evaluate> data) {
            evaMAdapter.addAll(data);

            evaMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
