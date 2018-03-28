package com.bm.mvpdemo.utils;

import io.reactivex.disposables.Disposable;

/**
 * Created by issuser on 2018/3/26.
 */

public interface RxActionManager {
    /**
     * 添加
     *
     * @param tag
     * @param disposable
     */
    void add(String tag, Disposable disposable);

    /**
     * 移除
     *
     * @param tag
     */
    void remove(String tag);

    /**
     * 取消
     *
     * @param tag
     */
    void cancel(String tag);
}
