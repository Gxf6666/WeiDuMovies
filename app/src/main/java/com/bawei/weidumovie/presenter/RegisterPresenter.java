package com.bawei.weidumovie.presenter;

import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/7<p>
 * <p>更改时间：2019/11/7<p>
 */
public class RegisterPresenter extends BasePresenter {
    public RegisterPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    Observable GetModel(Api api, Object... args) {
        return api.register((String)args[0],(String)args[1],(String)args[2],(String)args[3]);
    }
}
