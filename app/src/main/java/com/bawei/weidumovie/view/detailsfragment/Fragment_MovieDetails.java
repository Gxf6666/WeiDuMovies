package com.bawei.weidumovie.view.detailsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Information;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.InForPresenter;
import com.bawei.weidumovie.view.consion.DataCall;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public class Fragment_MovieDetails extends Fragment {

    private TextView movie_site,movie_phone,movie_path1;
    private InForPresenter inForPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_moviexq,null);
        movie_site = view.findViewById(R.id.movie_site);
        movie_phone = view.findViewById(R.id.movie_phone);
        movie_path1 = view.findViewById(R.id.movie_path1);

        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("Id",0);
        inForPresenter = new InForPresenter(new InForPresens());
        inForPresenter.Request(id);
        return view;
    }

    private class InForPresens implements DataCall<Information> {
        @Override
        public void Success(Information data) {
            movie_site.setText(data.address);
            movie_phone.setText(data.phone);
            movie_path1.setText(data.vehicleRoute);

        }

        @Override
        public void Error(Request request) {

        }
    }
}
