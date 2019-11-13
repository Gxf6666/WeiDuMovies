package com.bawei.weidumovie.view.moviedetailsfragment;
/*时间:2019/11/8 0008
创建人:郭学飞*/


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.MovieActor;
import com.bawei.weidumovie.model.bean.MovieDirec;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.MovieDetailPresenter;
import com.bawei.weidumovie.view.adpater.DaoyanDapter;
import com.bawei.weidumovie.view.adpater.PhotoAdapter;
import com.bawei.weidumovie.view.adpater.YanyuanDapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PhotoFragment extends Fragment {
    @BindView(R.id.photo_rv)
    RecyclerView mPhotoRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_photo, null);
        unbinder = ButterKnife.bind(this, v);
        MovieDetailPresenter movieDetailPresenter = new MovieDetailPresenter(new MovieDetailPresen());
        Intent intent = getActivity().getIntent();
        int movieid = intent.getIntExtra("movieid", 0);
        movieDetailPresenter.Request(movieid);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private class MovieDetailPresen implements DataCall<DetailsBean> {
        @Override
        public void Success(DetailsBean data) {
            List<String> posterList = data.posterList;
            PhotoAdapter photoAdapter = new PhotoAdapter(posterList,getContext());
            GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
            mPhotoRv.setLayoutManager(gridLayoutManager);
            mPhotoRv.setAdapter(photoAdapter);
        }

        @Override
        public void Error(Request request) {

        }
    }
}
