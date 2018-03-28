package com.bm.mvpdemo.https;

import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.utils.HttpResultFunction;
import com.bm.mvpdemo.utils.ServerResultFunction;
import com.trello.rxlifecycle2.components.RxActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by issuser on 2018/3/23.
 */

public class ApiMethod {

    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 创建通用的监听者
     * @param apiObservable
     * @return
     */
    public static Observable<BaseData> getObservable(Observable<BaseData> apiObservable, RxActivity activity){
        Observable observable;
        observable=apiObservable
                //对返回的数据做一次处理，成功--正常返回数据  失败抛出异常
                .map(new ServerResultFunction())
                //随生命周期自动管理.eg:onCreate(start)->onStop(end)
                .compose(activity.bindToLifecycle())
                .onErrorResumeNext(new HttpResultFunction())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
