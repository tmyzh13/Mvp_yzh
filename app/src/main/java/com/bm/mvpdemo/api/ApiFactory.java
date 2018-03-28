package com.bm.mvpdemo.api;

import com.bm.mvpdemo.https.HttpLoggingInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by issuser on 2018/3/22.
 */

public class ApiFactory {

    public static ApiFactory instance;

    private Retrofit retrofit;
    /**
     * 请求超时时间
     */
    private static final int DEFAULT_TIMEOUT=10000;

    private ApiFactory(){

    }

    public void  addUrl(String url){
                //增加http配置
        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        //超时时间
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        //设置网络拦截器
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor());

        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                //下面2个将retrofit 返回的call<>转化为Observeble<T>
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public static ApiFactory getInstance(){
        if(instance==null){
            instance=new ApiFactory();
        }
        return instance;
    }

    public <T>T create(Class<T> clz){
        if(retrofit!=null){
            return retrofit.create(clz);
        }
        throw new IllegalStateException("Please add a Retrofit instance");

    }



}
