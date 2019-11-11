package com.bawei.weidumovie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.MovieDetailPresenter;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetailsActivity extends BaseActivity {


    @BindView(R.id.poster)
    ImageView mPoster;
    @BindView(R.id.returnhot)
    ImageView mReturnhot;
    @BindView(R.id.score)
    TextView mScore;
    @BindView(R.id.comment)
    TextView mComment;
    @BindView(R.id.movie_name)
    TextView mMovieName;
    @BindView(R.id.movie_type)
    TextView mMovieType;
    @BindView(R.id.movie_duration)
    TextView mMovieDuration;
    @BindView(R.id.movie_time)
    TextView mMovieTime;
    @BindView(R.id.movie_area)
    TextView mMovieArea;
    private MovieDetailPresenter movieDetailPresenter;
    private int movieid;

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        movieid = intent.getIntExtra("movieid", 0);
        Toast.makeText(this, movieid +"", Toast.LENGTH_SHORT).show();
        movieDetailPresenter = new MovieDetailPresenter(new MovieDetailPresen());
        movieDetailPresenter.Request(movieid);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_movie_details;
    }


    @OnClick(R.id.returnhot)
    public void onViewClicked() {
    }

    private class MovieDetailPresen implements DataCall<DetailsBean> {
        @Override
        public void Success(DetailsBean data) {
            Glide.with(MovieDetailsActivity.this).load(data.imageUrl).into(mPoster);
        }

        @Override
        public void Error(Request request) {
            Toast.makeText(MovieDetailsActivity.this, request.message, Toast.LENGTH_SHORT).show();
        }
    }
}
