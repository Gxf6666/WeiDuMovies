package com.bawei.weidumovie.app;

import com.bawei.weidumovie.model.bean.Banners;
import com.bawei.weidumovie.model.bean.DetailsBean;
import com.bawei.weidumovie.model.bean.Evaluate;
import com.bawei.weidumovie.model.bean.Home;
import com.bawei.weidumovie.model.bean.HomeOne;
import com.bawei.weidumovie.model.bean.Information;
import com.bawei.weidumovie.model.bean.Logins;
import com.bawei.weidumovie.model.bean.MovieFocusBean;
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
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */
public interface Api {

    //登录
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Request<Logins>>login(@Field("email")String email,@Field("pwd")String pwd);
   //注册
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<Request> register(@Field("nickName")String nickName,@Field("pwd")String pwd,
                                 @Field("email")String email,@Field("code")String code);

    //获取email验证码
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<Request> sendOutEmailCode(@Field("email")String email);

    //轮播
    @GET("tool/v2/banner")
    Observable<Request<List<Banners>>>banner();

    //查询正在上映电影列表
    @GET("movie/v2/findReleaseMovieList")
    Observable<Request<List<Home>>>findReleaseMovieList(@Query("page")int page,@Query("count")int count);

    //查询即将上映电影列表
    @GET("movie/v2/findComingSoonMovieList")
    Observable<Request<List<HomeOne>>>findComingSoonMovieList(@Query("page")int page,@Query("count")int count);

   //查询热门电影列表
    @GET("movie/v2/findHotMovieList")
    Observable<Request<List<Home>>>findHotMovieList(@Query("page")int page,@Query("count")int count);

    //查询推荐影院信息
    @GET("cinema/v1/findRecommendCinemas")
    Observable<Request<List<Recommend>>> findRecommendCinemas(@Query("page")int page,@Query("count")int count);

    //查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<Request<List<Nearby>>>findNearbyCinemas(@Query("page")int page,@Query("count")int count);

    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<Request<List<QuYu>>>findRegionList();

    //根据区域查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<Request<List<QuYuQuery>>>findCinemaByRegion(@Query("regionId")int regionId);

    //查询影院详情
    @GET("cinema/v1/findCinemaInfo")
    Observable<Request<Information>>findCinemaInfo(@Query("cinemaId")int cinemaId);

   //查询电影详情
   @GET("movie/v2/findMoviesDetail")
   Observable<Request<DetailsBean>>findDetail(@Query("movieId")int movieId);

   //查询影院评价
   @GET("cinema/v1/findAllCinemaComment")
   Observable<Request<List<Evaluate>>>findAllCinemaComment(@Query("cinemaId")int cinemaId,@Query("page")int page,@Query("count")int count);


    //关注电影
    @GET("movie/v1/verify/followMovie")
    Observable<Request<MovieFocusBean>>focusmovie(@Header("userId") int userId, @Header("sessionId")String sessionId, @Query("movieId")int movieId);


    //取消关注电影
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<Request<MovieFocusBean>>cancelfocusmovie(@Header("userId") int userId, @Header("sessionId")String sessionId, @Query("movieId")int movieId);
}
