package com.bawei.weidumovie.model.bean;
/*时间:2019/11/11 0011
创建人:郭学飞*/


import java.util.List;

public class DetailsBean {
//    "commentNum": 38,
//            "duration": "117分钟",
//            "imageUrl": "http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg",

    public String duration;
    public String imageUrl;
    public double commentNum;
    public List<MovieActor> movieActor;
    public List<MovieDirec>movieDirector;
    public int movieId;
    public String movieType;
    public String name;
    public String placeOrigin;
    public List<String>posterList;
    public long  releaseTime;
    public double  score;
    public List<ShortFilm>shortFilmList;
    public String summary;
    public int  whetherFollow;
    public String message;
    public String status;

}
