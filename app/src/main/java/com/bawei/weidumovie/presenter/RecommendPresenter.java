package com.bawei.weidumovie.presenter;

import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/8<p>
 * <p>更改时间：2019/11/8<p>
 */
public class RecommendPresenter extends BasePresenter {
    public RecommendPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable GetModel(Api api, Object... args) {
        return api.findRecommendCinemas((int)args[0],(int)args[1]);
    }
}
