package com.bawei.weidumovie.app;

import com.bawei.weidumovie.model.bean.Logins;
import com.bawei.weidumovie.model.bean.Request;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */
public interface Api {

    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Request<List<Logins>>>login(@Field("email")String email,@Field("pwd")String pwd);
}
