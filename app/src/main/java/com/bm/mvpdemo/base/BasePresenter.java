package com.bm.mvpdemo.base;

import android.util.Log;

import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by john on 2018/3/28.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V view;

    /**
     * 绑定 在获取网络响应之后通过view传递给activity
     * @param view
     */
    public void attachView(V view){
        this.view=view;
    }

    /**
     * 解绑view
     */
    public void detachView(){
        this.view=null;
    }

    /**
     * 判断是否解绑 在网络请求时页面被终结，导致后续出现nullpointException
     * 在加入rxjava生命周期管理后理论上不会存在上面这个情况 页面ondestroy后会做解绑操作，同时网络请求也会停止发送
     * @return
     */
    public boolean isViewAttached(){
        return view!=null;
    }

    public V getView(){
        return view;
    }

    /**
     * 在页面对象创建完成后调用，可以用来初始化数据层对象
     */
    public abstract void onStart();

    protected RxFragmentActivity activity;
    private Reference<RxFragmentActivity> mActivityRef;

    public  void setRxActivity(RxFragmentActivity activity){
        mActivityRef=new WeakReference<RxFragmentActivity>(activity);
        this.activity=activity;
        Log.e("yzh","activity--"+activity.getClass().getName());
    }

    public  void clearRxActivity(){
        if(mActivityRef.get()!=null&&activity!=null){
            mActivityRef.clear();
            this.activity=null;
        }
    }
}
