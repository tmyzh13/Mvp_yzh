package com.bm.mvpdemo.api;

import com.bm.mvpdemo.bean.ArticleBean;
import com.bm.mvpdemo.bean.BannerBean;
import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.bean.HomeBean;
import com.bm.mvpdemo.constant.Urls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface HomeApi {

    @GET(Urls.GET_BANNER)
    Observable<BaseData<List<BannerBean>>> getBanner();

    @GET(Urls.GET_TOP_ARTICLE)
    Observable<BaseData<List<ArticleBean>>> getTopArticleList();

    @GET(Urls.GET_ARTICLE)
    Observable<BaseData<HomeBean>> getArticleList(@Path("page") int page);
}
