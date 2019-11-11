package com.bawei.weidumovie.presenter;
/*时间:2019/11/11 0011
创建人:郭学飞*/


import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;

public class MovieDetailPresenter extends BasePresenter{

    public MovieDetailPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable GetModel(Api api, Object... args) {
        return api.findDetail((int)args[0]);
    }
}
