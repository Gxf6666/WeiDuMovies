package com.bawei.weidumovie.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.weidumovie.R;

import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int LayoutId();
}
