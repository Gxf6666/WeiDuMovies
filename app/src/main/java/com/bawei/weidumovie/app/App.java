package com.bawei.weidumovie.app;

import android.app.Application;
import android.content.Context;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class App extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
