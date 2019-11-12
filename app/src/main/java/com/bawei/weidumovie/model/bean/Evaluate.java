package com.bawei.weidumovie.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class Evaluate {
//    commentId	int	评论id
//    commentUserId	int	评论人id
//    commentHeadPic	String	评论人头像地址
//    commentUserNam	String	评论人昵称
//    commentContent	String	影院评论内容
//    commentTime	Long	评论时间(毫秒)
//    greatNum	int	点赞数
//    greatHeadPic	List<String>	回复用户头像
//    hotComment	int	是否为热评（0为否，1为是）
//    isGreat	int	是否点过赞（0为否，1为是）

    public int commentId;
    public int commentUserId;
    public int greatNum;
    public int hotComment;
    public int isGreat;
    public String  commentHeadPic;
    public String  commentUserNam;
    public String  commentContent;
    public List<String>  greatHeadPic;
    public long  commentTime;
}
