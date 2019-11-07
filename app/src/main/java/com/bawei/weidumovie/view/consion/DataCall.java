package com.bawei.weidumovie.view.consion;


import com.bawei.weidumovie.model.bean.Request;


/**
 * <p>文件描述：<p>
 * <p>作者：染<p>
 * <p>创建时间：2019/11/6<p>
 * <p>更改时间：2019/11/6<p>
 */

public interface DataCall<T> {
    void Success(T data);
    void Error(Request request);
}
