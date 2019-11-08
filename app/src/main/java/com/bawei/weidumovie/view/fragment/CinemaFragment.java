package com.bawei.weidumovie.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.view.fragment1.Fragment_Movie;
import com.bawei.weidumovie.view.fragment1.Fragment_Nearby;
import com.bawei.weidumovie.view.fragment1.Fragment_Region;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class CinemaFragment extends Fragment implements View.OnClickListener {
    private RadioButton movie_rb;
    private RadioButton movie_rb1;
    private RadioButton movie_rb2;
    private RadioGroup movie_rg;
    private ViewPager vp;
    private List<Fragment> list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_movie, null);
        initView(view);
        list = new ArrayList<>();
        list.add(new Fragment_Movie());
        list.add(new Fragment_Nearby());
        list.add(new Fragment_Region());

        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                    movie_rg.check(movie_rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        return view;
    }
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.movie_rb:
                        vp.setCurrentItem(0);
                        break;
                case R.id.movie_rb1:
                       vp.setCurrentItem(1);
                       break;
                case R.id.movie_rb2:
                        vp.setCurrentItem(2);
                        break;
            }
    }
    private void initView(View view) {
        movie_rb = (RadioButton) view.findViewById(R.id.movie_rb);
        movie_rb1 = (RadioButton) view.findViewById(R.id.movie_rb1);
        movie_rb2 = (RadioButton) view.findViewById(R.id.movie_rb2);
        movie_rg = (RadioGroup) view.findViewById(R.id.movie_rg);
        vp = (ViewPager) view.findViewById(R.id.vp);

        movie_rb.setOnClickListener(this);
        movie_rb1.setOnClickListener(this);
        movie_rb2.setOnClickListener(this);

    }


}
