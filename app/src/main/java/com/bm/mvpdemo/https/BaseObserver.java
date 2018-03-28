package com.bm.mvpdemo.https;

import android.util.Log;

import com.bm.mvpdemo.bean.BaseData;
import com.bm.mvpdemo.utils.ApiException;
import com.bm.mvpdemo.utils.ExceptionEngine;
import com.bm.mvpdemo.utils.RxActionManagerImpl;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 考虑是否要直接加入view
 * Created by issuser on 2018/3/26.
 */

public abstract class BaseObserver<T> implements Observer<BaseData<T>> {

    private final String TAG="yzhBaseObserver";
    private final int RESPONSE_CODE_OK=0;
    private String tag;

    /**
     * 在具体的业务里需要实现的
     * @param t
     */
    protected abstract void onSuccess(T t);
    protected abstract void onFail(ApiException e);
//    protected abstract void onNetStart();

    public BaseObserver(String tag){
        this.tag=tag;
        Log.e("yzh","tag=="+tag);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.e("yzh","BaseObserver--onSubscribe");
//        onNetStart();
        RxActionManagerImpl.getInstance().add(tag, d);
    }

    @Override
    public void onNext(BaseData<T> tBaseData) {
        Log.e("yzh","baseObserver--onNext");
        RxActionManagerImpl.getInstance().remove(tag);
        //在observable map方法中过滤过一次 这里应该只走到true 两种方式 做一个备选方案
        if(tBaseData.getCode()==RESPONSE_CODE_OK){
            onSuccess(tBaseData.getData());
        }else{
            onFail(new ApiException(tBaseData.getCode(),tBaseData.getMsg()));
        }
    }
    @Override
    public void onComplete() {
        Log.e("yzh","baseObserver--onComplete");
    }

    /**
     * 转化统一的异常 方便输出
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        Log.e("yzh","BaseObserver--onError");
        RxActionManagerImpl.getInstance().remove(tag);
        if(e instanceof ApiException){
            onFail((ApiException) e);
        }else{
            Log.e("yzh","onError--false");
            onFail(new ApiException(e, ExceptionEngine.UN_KNOWN_ERROR));
        }
    }

    /**
     * 暂时只记录了两个异常 可以对后面其他情况增加 改方法暂时屏蔽
     */
//    @Override
//    public void onError(Throwable e) {
//        view.hideloading();
//        if(e instanceof HttpException){
//            HttpException httpException=(HttpException)e;
//            errorCode=httpException.code();
//            errorMsg=httpException.message();
//        }else if(e instanceof SocketTimeoutException){
//            errorCode=RESPONSE_CODE_FAIL;
//            errorMsg="服务器响应超时";
//        }
//        onFail(errorCode,errorMsg);
//    }

//    public void onFail(int code,String errorMsg){
//      view.showToast(errorMsg);
//    }
}
