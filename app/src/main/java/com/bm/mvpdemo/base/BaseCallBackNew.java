package com.bm.mvpdemo.base;

/**
 * Created by issuser on 2018/3/27.
 */

public interface BaseCallBackNew<T> {

    void onSuccess(T data);
    void onFailure(int code, String msg);
}
