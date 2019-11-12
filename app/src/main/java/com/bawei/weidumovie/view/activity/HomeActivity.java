package com.bawei.weidumovie.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.view.fragment.CinemaFragment;
import com.bawei.weidumovie.view.fragment.FilmFragment;
import com.bawei.weidumovie.view.fragment.ThirdlyFragment;
import com.kyle.radiogrouplib.NestedRadioGroup;
import com.kyle.radiogrouplib.NestedRadioLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.frame)
    FrameLayout mFrame;
    @BindView(R.id.tv_movies)
    TextView mTvMovies;
    @BindView(R.id.rb_movies)
    NestedRadioLayout mRbMovies;
    @BindView(R.id.tv_cinema)
    TextView mTvCinema;
    @BindView(R.id.rb_cinema)
    NestedRadioLayout mRbCinema;
    @BindView(R.id.tv_mine)
    TextView mTvMine;
    @BindView(R.id.rb_mine)
    NestedRadioLayout mRbMine;
    @BindView(R.id.rg_group)
    NestedRadioGroup mRgGroup;
    @BindView(R.id.witch)
    RelativeLayout mSwitch;
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
        mTvMovies.setVisibility(View.VISIBLE);

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @OnClick({R.id.rb_movies, R.id.rb_cinema, R.id.rb_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_movies:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(filmFragment)
                        .hide(cinemaFragment)
                        .hide(thirdlyFragment)
                        .commit();
                mTvMovies.setVisibility(View.VISIBLE);
                mTvCinema.setVisibility(View.GONE);
                mTvMine.setVisibility(View.GONE);
                break;
            case R.id.rb_cinema:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(cinemaFragment)
                        .hide(filmFragment)
                        .hide(thirdlyFragment)
                        .commit();
                mTvCinema.setVisibility(View.VISIBLE);
                mTvMovies.setVisibility(View.GONE);
                mTvMine.setVisibility(View.GONE);
                break;
            case R.id.rb_mine:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(thirdlyFragment)
                        .hide(filmFragment)
                        .hide(cinemaFragment)
                        .commit();
                mTvMine.setVisibility(View.VISIBLE);
                mTvCinema.setVisibility(View.GONE);
                mTvMovies.setVisibility(View.GONE);
                break;
        }
    }

}
