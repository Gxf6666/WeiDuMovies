package com.bawei.weidumovie.presenter;

import com.bawei.weidumovie.app.Api;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.model.okhttp.OkHttp;
import com.bawei.weidumovie.view.consion.DataCall;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */

public abstract class BasePresenter {

    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void Request(Object... args) {
        Api api = OkHttp.getInstance().create(Api.class);
        GetModel(api, args).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Request>() {
                    @Override
                    public void accept(Request object) throws Exception {
                        if (object.status.equals("0000")) {
                            dataCall.Success(object.result);
                        } else {
                            dataCall.Error(object);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    abstract Observable GetModel(Api api, Object... args);
}
