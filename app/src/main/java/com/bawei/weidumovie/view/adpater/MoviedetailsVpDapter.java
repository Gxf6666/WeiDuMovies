package com.bawei.weidumovie.view.adpater;
/*时间:2019/11/12 0012
创建人:郭学飞*/


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MoviedetailsVpDapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;

    public MoviedetailsVpDapter(FragmentManager fm, Context context, ArrayList<String> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
