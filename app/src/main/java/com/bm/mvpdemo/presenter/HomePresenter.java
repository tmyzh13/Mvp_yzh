package com.bm.mvpdemo.presenter;

import android.util.Log;

import com.bm.mvpdemo.api.ApiFactory;
import com.bm.mvpdemo.api.HomeApi;
import com.bm.mvpdemo.api.LoginApi;
import com.bm.mvpdemo.base.BasePresenter;
import com.bm.mvpdemo.bean.ArticleBean;
import com.bm.mvpdemo.bean.BannerBean;
import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.bean.HomeBean;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.https.ApiMethod;
import com.bm.mvpdemo.https.BaseObserver;
import com.bm.mvpdemo.utils.ApiException;
import com.bm.mvpdemo.utils.HttpResultFunction;
import com.bm.mvpdemo.utils.ServerResultFunction;
import com.bm.mvpdemo.views.interfaces.HomeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter extends BasePresenter<HomeView> {

    private HomeApi api ;
    private LoginApi loginApi;

    public HomePresenter(){
        api=ApiFactory.getInstance().create(HomeApi.class);
    }

    @Override
    public void onStart() {

    }

    public void getBanner(){
        api.getBanner()
                .map(new ServerResultFunction())
                .compose(activity.bindToLifecycle())
                .onErrorResumeNext(new HttpResultFunction())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<BannerBean>>("home") {
                    @Override
                    protected void onSuccess(List<BannerBean> bannerBeans) {
                        getView().showBanner(bannerBeans);
                    }

                    @Override
                    protected void onFail(ApiException e) {
                        Log.e("yzh",e.getMsg());
                    }
                });
    }

    public void getTopAticle(){
        api.getTopArticleList()
                .map(new ServerResultFunction())
                .compose(activity.bindToLifecycle())
                .onErrorResumeNext(new HttpResultFunction())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<ArticleBean>>("home") {
                    @Override
                    protected void onSuccess(List<ArticleBean> data) {

                    }

                    @Override
                    protected void onFail(ApiException e) {

                    }

                });
    }

    public void getAticleList(int curPage){
        api.getArticleList(curPage)
                .map(new ServerResultFunction())
                .compose(activity.bindToLifecycle())
                .onErrorResumeNext(new HttpResultFunction())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeBean>("home") {
                    @Override
                    protected void onSuccess(HomeBean o) {

                    }

                    @Override
                    protected void onFail(ApiException e) {

                    }


                });
    }

}
