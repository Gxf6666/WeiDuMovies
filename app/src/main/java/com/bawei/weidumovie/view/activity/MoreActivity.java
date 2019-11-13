package com.bawei.weidumovie.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.view.fragment_more.Fragment_More;
import com.bawei.weidumovie.view.fragment_more.Fragment_Morerm;
import com.bawei.weidumovie.view.fragment_more.Fragment_Moresy;

import java.util.ArrayList;

public class MoreActivity extends BaseActivity {


    private ArrayList<Fragment> list;
    private ImageView movie_imager;
    private RadioButton more_rb;
    private RadioButton more_rb1;
    private RadioButton more_rb2;
    private RadioGroup more_rg;
    private ViewPager more_vp;

    @Override
    protected void initView(Bundle savedInstanceState) {
        movie_imager = findViewById(R.id.movie_imager);
        more_rb =  findViewById(R.id.more_rb);
        more_rb1 = findViewById(R.id.more_rb1);
        more_rb2 = findViewById(R.id.more_rb2);
         more_vp = findViewById(R.id.more_vp);
        more_rg =  findViewById(R.id.more_rg);
        list = new ArrayList<>();
        list.add(new Fragment_More());
        list.add(new Fragment_Moresy());
        list.add(new Fragment_Morerm());


        more_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        more_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                more_rg.check(more_rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        more_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.more_rb:
                        more_vp.setCurrentItem(0);
                        break;
                    case R.id.more_rb1:
                        more_vp.setCurrentItem(1);
                        break;
                    case R.id.more_rb2:
                        more_vp.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_more;
    }

}
