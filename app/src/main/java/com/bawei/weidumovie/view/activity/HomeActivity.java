package com.bawei.weidumovie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.view.fragment.CinemaFragment;
import com.bawei.weidumovie.view.fragment.FilmFragment;
import com.bawei.weidumovie.view.fragment.ThirdlyFragment;
import com.kyle.radiogrouplib.NestedRadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.frame)
    FrameLayout mFrame;
    //    @BindView(R.id.tv_movies)
//    TextView mTvMovies;
//    @BindView(R.id.rb_movies)
//    NestedRadioLayout mRbMovies;
//    @BindView(R.id.tv_cinema)
//    TextView mTvCinema;
//    @BindView(R.id.rb_cinema)
//    NestedRadioLayout mRbCinema;
//    @BindView(R.id.tv_mine)
//    TextView mTvMine;
//    @BindView(R.id.rb_mine)
//    NestedRadioLayout mRbMine;
//    @BindView(R.id.rg_group)
    //NestedRadioGroup mRgGroup;
//    @BindView(R.id.witch)
//    RelativeLayout mSwitch;
    @BindView(R.id.movie_img)
    ImageView movieImg;
    @BindView(R.id.movie_tv)
    TextView movieTv;
    @BindView(R.id.movie_llt)
    LinearLayout movieLlt;
    @BindView(R.id.movie)
    RelativeLayout movie;
    @BindView(R.id.yingyuan_img)
    ImageView yingyuanImg;
    @BindView(R.id.yingyuan_tv)
    TextView yingyuanTv;
    @BindView(R.id.yingyuan_llt)
    LinearLayout yingyuanLlt;
    @BindView(R.id.yingyuan)
    RelativeLayout yingyuan;
    @BindView(R.id.mine_img)
    ImageView mineImg;
    @BindView(R.id.mine_tv)
    TextView mineTv;
    @BindView(R.id.mine_llt)
    LinearLayout mineLlt;
    @BindView(R.id.mine)
    RelativeLayout mine;
    private FilmFragment filmFragment;
    private CinemaFragment cinemaFragment;
    private ThirdlyFragment thirdlyFragment;

    @Override
    protected void initView(Bundle savedInstanceState) {
        filmFragment = new FilmFragment();
        cinemaFragment = new CinemaFragment();
        thirdlyFragment = new ThirdlyFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, filmFragment)
                .add(R.id.frame, cinemaFragment)
                .add(R.id.frame, thirdlyFragment)
                .show(filmFragment)
                .hide(cinemaFragment)
                .hide(thirdlyFragment)
                .commit();
//        mTvMovies.setVisibility(View.VISIBLE);

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @OnClick({R.id.movie,R.id.yingyuan,R.id.mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.movie:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(filmFragment)
                        .hide(cinemaFragment)
                        .hide(thirdlyFragment)
                        .commit();

                break;
            case R.id.yingyuan:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(cinemaFragment)
                        .hide(filmFragment)
                        .hide(thirdlyFragment)
                        .commit();

                break;
            case R.id.mine:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(thirdlyFragment)
                        .hide(filmFragment)
                        .hide(cinemaFragment)
                        .commit();

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.movie,R.id.yingyuan,R.id.mine})
    public void onClick(View view){
        yingyuanLlt.setVisibility(View.GONE);
        yingyuanImg.setVisibility(View.VISIBLE);

        mineLlt.setVisibility(View.GONE);
        mineImg.setVisibility(View.VISIBLE);
         if (view.getId() == R.id.movie) {
              movieLlt.setVisibility(View.VISIBLE);
              movieImg.setVisibility(View.VISIBLE);
          }else if (view.getId() == R.id.yingyuan){
            yingyuanLlt.setVisibility(View.VISIBLE);
            yingyuanImg.setVisibility(View.VISIBLE);
            movieLlt.setVisibility(View.INVISIBLE);
          }else if (view.getId() == R.id.mine){
              mineLlt.setVisibility(View.VISIBLE);
              mineImg.setVisibility(View.VISIBLE);
             yingyuanLlt.setVisibility(View.INVISIBLE);
             movieLlt.setVisibility(View.INVISIBLE);
       }
   }
}
