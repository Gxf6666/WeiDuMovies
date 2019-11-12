package com.bawei.weidumovie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.MovieDetailPresenter;
import com.bawei.weidumovie.view.adpater.MoviedetailsVpDapter;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bawei.weidumovie.view.fragment.FilmFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.FilmreviewFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.ForeshowFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.IntroduceFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.PhotoFragment;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
    @BindView(R.id.emptyfalse)
    ImageView mEmptyfalse;
    @BindView(R.id.atteationno)
    RelativeLayout mAtteationno;
    @BindView(R.id.emptytrue)
    ImageView mEmptytrue;
    @BindView(R.id.atteationyes)
    RelativeLayout mAtteationyes;
    @BindView(R.id.detailtab)
    TabLayout mDetailtab;
    @BindView(R.id.detailvp)
    ViewPager mDetailvp;
    private MovieDetailPresenter movieDetailPresenter;
    private int movieid;
    private ArrayList<String>strings=new ArrayList<>();
    private ArrayList<Fragment>fragments=new ArrayList<>();
    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        movieid = intent.getIntExtra("movieid", 0);
        movieDetailPresenter = new MovieDetailPresenter(new MovieDetailPresen());
        movieDetailPresenter.Request(movieid);
        strings.add("介绍");
        strings.add("预告");
        strings.add("剧照");
        strings.add("影评");
        fragments.add(new IntroduceFragment());
        fragments.add(new ForeshowFragment());
        fragments.add(new PhotoFragment());
        fragments.add(new FilmreviewFragment());
        mDetailvp.setAdapter(new MoviedetailsVpDapter(getSupportFragmentManager(),MovieDetailsActivity.this,strings,fragments));
        mDetailtab.setupWithViewPager(mDetailvp,true);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_movie_details;
    }


    @OnClick(R.id.returnhot)
    public void onViewClicked() {
    }

    @OnClick({R.id.emptyfalse, R.id.emptytrue})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.emptyfalse:

                break;
            case R.id.emptytrue:

                break;
        }
    }

    private class MovieDetailPresen implements DataCall<DetailsBean> {
        @Override
        public void Success(DetailsBean data) {
            Glide.with(MovieDetailsActivity.this).load(data.imageUrl).into(mPoster);
            mScore.setText("评分  " + data.score + "分");
            mComment.setText("评论  " + data.commentNum);
            mMovieName.setText(data.name);
            Toast.makeText(MovieDetailsActivity.this, "类型" + data.movieType + "上映" + data.placeOrigin + "评论" + data.commentNum, Toast.LENGTH_SHORT).show();
            mMovieType.setText(data.movieType);
            mMovieDuration.setText(data.duration);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "日");
            String format = simpleDateFormat.format(data.releaseTime);
            mMovieTime.setText(format);
            mMovieArea.setText(data.placeOrigin + "上映");
        }

        @Override
        public void Error(Request request) {
            Toast.makeText(MovieDetailsActivity.this, request.message, Toast.LENGTH_SHORT).show();
        }
    }
}
