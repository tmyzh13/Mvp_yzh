package com.bm.mvpdemo.base;

import android.content.Context;

/**
 * Created by john on 2018/3/28.
 */

public interface BaseView {

    /**
     * 显示网络请求加载转圈
     */
    void showLoading();

    /**
     * 关闭加载转圈
     */
    void hideLoading();

    /**
     * 吐息接口返回信息
     * @param msg
     */
    void showToast(String msg);

    void showErr();
    Context getContext();
}
