package com.bawei.weidumovie.app;

import com.bawei.weidumovie.model.bean.Banners;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.model.bean.Logins;
import com.bawei.weidumovie.model.bean.Nearby;
import com.bawei.weidumovie.model.bean.QuYu;
import com.bawei.weidumovie.model.bean.QuYuQuery;
import com.bawei.weidumovie.model.bean.Recommend;
import com.bawei.weidumovie.model.bean.Request;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */
public interface Api {

    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Request<Logins>>login(@Field("email")String email,@Field("pwd")String pwd);

    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<Request> register(@Field("nickName")String nickName,@Field("pwd")String pwd,
                                 @Field("email")String email,@Field("code")String code);

    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<Request> sendOutEmailCode(@Field("email")String email);

    @GET("tool/v2/banner")
    Observable<Request<List<Banners>>>banner();

    @GET("movie/v2/findReleaseMovieList")
    Observable<Request<List<Home>>>findReleaseMovieList(@Query("page")int page,@Query("count")int count);

    @GET("movie/v2/findComingSoonMovieList")
    Observable<Request<List<HomeOne>>>findComingSoonMovieList(@Query("page")int page,@Query("count")int count);


    @GET("movie/v2/findHotMovieList")
    Observable<Request<List<Home>>>findHotMovieList(@Query("page")int page,@Query("count")int count);

    @GET("cinema/v1/findRecommendCinemas")
    Observable<Request<List<Recommend>>> findRecommendCinemas(@Query("page")int page,@Query("count")int count);

    @GET("cinema/v1/findNearbyCinemas")
    Observable<Request<List<Nearby>>>findNearbyCinemas(@Query("page")int page,@Query("count")int count);


    @GET("tool/v2/findRegionList")
    Observable<Request<List<QuYu>>>findRegionList();

    @GET("cinema/v2/findCinemaByRegion")
    Observable<Request<List<QuYuQuery>>>findCinemaByRegion(@Query("regionId")int regionId);

}
