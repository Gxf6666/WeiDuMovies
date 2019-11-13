package com.bawei.weidumovie.presenter;
/*时间:2019/11/13 0013
创建人:郭学飞*/


import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;

public class CancelMovieFocusPresenter extends BasePresenter{

    public CancelMovieFocusPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable GetModel(Api api, Object... args) {
        return api.cancelfocusmovie((int)args[0],(String)args[1],(int)args[2]);
    }
}
