package com.bm.mvpdemo.api;

import com.bm.mvpdemo.bean.BannerBean;
import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.constant.Urls;

import java.util.List;
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

    @GET(Urls.GET_BANNER)
    Observable<BaseData<BannerBean>> getBanner(@QueryMap Map<String,Object> request);


}
