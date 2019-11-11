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
import com.bawei.weidumovie.model.bean.Nearby;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.NearbyPersenter;
import com.bawei.weidumovie.view.adpater.NearbyMAdapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class Fragment_Nearby extends Fragment {

    private RecyclerView rlv1;
    private NearbyPersenter nearbyPersenter;
    private NearbyMAdapter nearbyMAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.movie_nearby,null);
        rlv1 = view.findViewById(R.id.rlv1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv1.setLayoutManager(linearLayoutManager);

        nearbyMAdapter = new NearbyMAdapter(getContext());
        rlv1.setAdapter(nearbyMAdapter);
        nearbyPersenter = new NearbyPersenter(new NearbyPersen());
        nearbyPersenter.Request(1,5);
        return view;

    }

    private class NearbyPersen implements DataCall<List<Nearby>> {
        @Override
        public void Success(List<Nearby> data) {
                nearbyMAdapter.addAll(data);

                nearbyMAdapter.notifyDataSetChanged();
        }

        @Override
        public void Error(Request request) {

        }
    }
}
