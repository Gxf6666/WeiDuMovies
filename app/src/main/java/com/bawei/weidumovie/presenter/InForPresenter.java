package com.bawei.weidumovie.presenter;

import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public class InForPresenter extends BasePresenter {
    public InForPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable GetModel(Api api, Object... args) {
        return api.findCinemaInfo((int)args[0]);
    }
}
