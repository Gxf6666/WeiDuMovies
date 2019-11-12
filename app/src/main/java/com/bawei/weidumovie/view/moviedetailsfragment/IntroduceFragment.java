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
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.MovieActor;
import com.bawei.weidumovie.model.bean.MovieDirec;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.MovieDetailPresenter;
import com.bawei.weidumovie.view.adpater.DaoyanDapter;
import com.bawei.weidumovie.view.adpater.YanyuanDapter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class IntroduceFragment extends Fragment {


    @BindView(R.id.tv_juqing)
    TextView mTvJuqing;
    @BindView(R.id.tv_daoyan)
    TextView mTvDaoyan;
    @BindView(R.id.item_daoyan_rec)
    RecyclerView mItemDaoyanRec;
    @BindView(R.id.tv_yanyuan)
    TextView mTvYanyuan;
    @BindView(R.id.item_yanyuan_rec)
    RecyclerView mItemYanyuanRec;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_introduce, null);
        MovieDetailPresenter movieDetailPresenter = new MovieDetailPresenter(new MovieDetailPresen());
        Intent intent = getActivity().getIntent();
        int movieid = intent.getIntExtra("movieid", 0);
        movieDetailPresenter.Request(movieid);
        unbinder = ButterKnife.bind(this, v);
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
             mTvJuqing.setText(data.summary);
             mTvDaoyan.setText("导演("+data.movieDirector.size()+")");
             mTvYanyuan.setText("演员("+data.movieActor.size()+")");
             List<MovieDirec> movieDirector = data.movieDirector;
             List<MovieActor> movieActor = data.movieActor;
            DaoyanDapter daoyanDapter=new DaoyanDapter(movieDirector,getContext());
            YanyuanDapter yanyuanDapter=new YanyuanDapter(movieActor,getContext());
            LinearLayoutManager linearLayoutManagerdaoyan=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
            GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
            mItemDaoyanRec.setLayoutManager(linearLayoutManagerdaoyan);
            mItemDaoyanRec.setAdapter(daoyanDapter);
            mItemYanyuanRec.setLayoutManager(gridLayoutManager);
            mItemYanyuanRec.setAdapter(yanyuanDapter);
        }

        @Override
        public void Error(Request request) {

        }
    }
}
