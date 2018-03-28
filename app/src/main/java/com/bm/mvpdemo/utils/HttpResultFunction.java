package com.bm.mvpdemo.utils;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by issuser on 2018/3/26.
 */

public class HttpResultFunction implements Function<Throwable,Observable> {
    @Override
    public Observable apply(Throwable throwable) throws Exception {
        Log.e("yzh","HttpResultFunction:--"+throwable.toString());
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
