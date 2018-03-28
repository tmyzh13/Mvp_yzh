package com.bm.mvpdemo.utils;

import android.util.Log;


import com.bm.mvpdemo.bean.BaseData;

import io.reactivex.functions.Function;

/**
 * 转化接口请求成功
 * Created by issuser on 2018/3/26.
 */

public class ServerResultFunction<T> implements Function<BaseData<T>,Object> {
    @Override
    public Object apply(BaseData<T> tBaseData) throws Exception {
        if(tBaseData.getCode()!=0){
            //说明服务器返回的错误情况 如登录的账号密码错误之类
            Log.e("yzh","服务器报错");
            throw new ServerException(tBaseData.getCode(),tBaseData.getMsg());
        }
        return tBaseData;
    }
}
