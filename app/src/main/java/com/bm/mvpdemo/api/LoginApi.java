package com.bm.mvpdemo.api;

import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.constant.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by john on 2018/3/28.
 */

public interface LoginApi {

    @GET(Urls.LOGIN)
    Observable<BaseData<UserBean>> login(@QueryMap Map<String,Object> request);
}
