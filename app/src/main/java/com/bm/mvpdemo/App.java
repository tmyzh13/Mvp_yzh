package com.bm.mvpdemo;

import android.app.Application;

import com.bm.mvpdemo.api.ApiFactory;
import com.bm.mvpdemo.constant.Urls;
import com.bm.mvpdemo.utils.ToastMgr;

import retrofit2.Retrofit;

/**
 * Created by john on 2018/3/28.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化api工厂1
        ApiFactory.getInstance().addUrl(Urls.BASE);
        ToastMgr.init(getApplicationContext());

    }
}
