package com.bawei.weidumovie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.MovieFocusBean;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.CancelMovieFocusPresenter;
import com.bawei.weidumovie.presenter.MovieDetailPresenter;
import com.bawei.weidumovie.presenter.MovieFocusPresenter;
import com.bawei.weidumovie.view.adpater.MoviedetailsVpDapter;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bawei.weidumovie.view.fragment.FilmFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.FilmreviewFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.ForeshowFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.IntroduceFragment;
import com.bawei.weidumovie.view.moviedetailsfragment.PhotoFragment;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

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
    private MovieFocusPresenter movieFocusPresenter;
    private CancelMovieFocusPresenter cancelMovieFocusPresenter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        movieid = intent.getIntExtra("movieid", 0);
        movieDetailPresenter = new MovieDetailPresenter(new MovieDetailPresen());
        movieDetailPresenter.Request(movieid);
        Toast.makeText(this, movieid+"", Toast.LENGTH_SHORT).show();
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
        //关注电影presenter
        movieFocusPresenter = new MovieFocusPresenter(new MovieFocusPresen());
        //取消关注电影presenter
        cancelMovieFocusPresenter = new CancelMovieFocusPresenter(new CancelMovieFocusPresen());
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_movie_details;
    }


    @OnClick(R.id.returnhot)
    public void onViewClicked() {
    }

    @OnClick({R.id.emptytrue, R.id.emptyfalse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.emptytrue:
                cancelguanzhu(13680,"157364555232013680",movieid);
                break;
            case R.id.emptyfalse:
                guanzhu(13680,"157364555232013680",movieid);
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
            mMovieType.setText(data.movieType);
            mMovieDuration.setText(data.duration);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + "年" + "MM" + "月" + "dd" + "日");
            String format = simpleDateFormat.format(data.releaseTime);
            mMovieTime.setText(format);
            mMovieArea.setText(data.placeOrigin + "上映");
            Toast.makeText(MovieDetailsActivity.this, data.whetherFollow+"", Toast.LENGTH_SHORT).show();
            if (data.whetherFollow==1){
                mAtteationno.setVisibility(View.GONE);
                mAtteationyes.setVisibility(View.VISIBLE);
            }else if (data.whetherFollow==2){
                mAtteationyes.setVisibility(View.GONE);
                mAtteationno.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void Error(Request request) {
            Toast.makeText(MovieDetailsActivity.this, request.message, Toast.LENGTH_SHORT).show();
        }
    }

    private class MovieFocusPresen implements DataCall<MovieFocusBean> {
        @Override
        public void Success(MovieFocusBean data) {
                Toast.makeText(MovieDetailsActivity.this, data.message, Toast.LENGTH_SHORT).show();
                mAtteationno.setVisibility(View.GONE);
                mAtteationyes.setVisibility(View.VISIBLE);
        }
        @Override
        public void Error(Request request) {
            Toast.makeText(MovieDetailsActivity.this, request.message, Toast.LENGTH_SHORT).show();
        }
    }

    private void guanzhu(int userid,String sessionid,int movieid){
        movieFocusPresenter.Request(userid,sessionid,movieid);
    }
    private void cancelguanzhu(int userid,String sessionid,int movieid){
        cancelMovieFocusPresenter.Request(userid,sessionid,movieid);
    }
    private class CancelMovieFocusPresen implements DataCall<MovieFocusBean> {
        @Override
        public void Success(@NotNull MovieFocusBean data) {
                Toast.makeText(MovieDetailsActivity.this, "取消关注成功", Toast.LENGTH_SHORT).show();
                mAtteationno.setVisibility(View.VISIBLE);
                mAtteationyes.setVisibility(View.GONE);
        }

        @Override
        public void Error(Request request) {
            Toast.makeText(MovieDetailsActivity.this, request.message, Toast.LENGTH_SHORT).show();
        }
    }
}
