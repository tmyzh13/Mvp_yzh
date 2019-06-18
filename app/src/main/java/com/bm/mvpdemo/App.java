package com.bm.mvpdemo;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.bm.mvpdemo.api.ApiFactory;
import com.bm.mvpdemo.constant.Urls;
import com.bm.mvpdemo.utils.ToastMgr;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by john on 2018/3/28.
 */

public class App extends MultiDexApplication {

     private static final List<String> APP_LIKE_LIST = new ArrayList<>();
    private static App app;

    public static App getInstance(){
        return app;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        findAppLike();
        MultiDex.install(this);
    }

    private void findAppLike() {

        for (String classPath : APP_LIKE_LIST) {
            try{
                Class clazz = Class.forName(classPath);
            }catch (Exception ignore){

            }
        }
    }

    //    attachBaseContext首先执行然后才会执行onCreate方法
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化api工厂1
        ApiFactory.getInstance().addUrl(Urls.BASE_URL);
        ToastMgr.init(getApplicationContext());

        initSmartRefresh();
        app = this;
    }

    private void initSmartRefresh() {

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsHeader(context);
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context);
            }
        });
    }
}
