package com.bawei.weidumovie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.model.bean.Information;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.InForPresenter;
import com.bawei.weidumovie.view.consion.DataCall;
import com.bawei.weidumovie.view.detailsfragment.Fragment_MovieDetails;
import com.bawei.weidumovie.view.detailsfragment.Fragment_MovieReView;

import java.util.ArrayList;

public class InForActivity extends BaseActivity {


    private RadioButton but_yyxq;
    private RadioButton but_yypj;
    private RadioGroup rg_dy;
    private ViewPager vp;
    private Button but_dypq;
    private InForPresenter inForPresenter;
    private TextView text_if;
    private ArrayList<Fragment> list;
    private TextView text_3D;
    private TextView text_et;
    private ImageView tupian;

    @Override
    protected void initView(Bundle savedInstanceState) {
        text_if = findViewById(R.id.text_if);
        text_3D = findViewById(R.id.text_3D);
        text_et = findViewById(R.id.text_et);
        but_yyxq = findViewById(R.id.but_yyxq);
        but_yypj = findViewById(R.id.but_yypj);
        rg_dy = findViewById(R.id.rg_dy);
        vp = findViewById(R.id.vp);
        but_dypq = findViewById(R.id.but_dypq);

        list = new ArrayList<>();
        list.add(new Fragment_MovieDetails());
        list.add(new Fragment_MovieReView());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg_dy.check(rg_dy.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg_dy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but_yyxq:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.but_yypj:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("Id", 0);


        inForPresenter = new InForPresenter(new InForPresen());
        inForPresenter.Request(id);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_in_for;
    }




    private class InForPresen implements DataCall<Information> {



        @Override
        public void Success(Information data) {
            text_if.setText(data.name);
            String[] split = data.label.split(",");
            if (split.length == 1) {
                text_3D.setText(split[0]);
                text_et.setVisibility(View.GONE);
            }else {
                text_3D.setText(split[0]);
                text_et.setText(split[1]);
            }
        }

        @Override
        public void Error(Request request) {

        }
    }
}
