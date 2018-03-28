package com.bm.mvpdemo.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bm.mvpdemo.utils.AppManager;
import com.bm.mvpdemo.utils.ToastMgr;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.ButterKnife;

/**
 * Created by john on 2018/3/28.
 */

public abstract class BaseActivity <V extends BaseView,T extends BasePresenter> extends RxActivity implements BaseView {

    protected T presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        //将当前activity加入自定义的app管理中
        AppManager.getInstance().addActivity(this);
        presenter=creatPresenter();

        if(presenter!=null){
            //绑定当前页面的view,用于presnter获取数据之后控制activity的变化
            presenter.attachView((V)this);
            presenter.setRxActivity(this);
        }
        ButterKnife.bind(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        init(savedInstanceState);
        if(presenter!=null){
            presenter.onStart();
        }
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void showToast(String msg) {
        if(!TextUtils.isEmpty(msg)){
            ToastMgr.show(msg);
        }
    }

    @Override
    public void showErr() {
        ToastMgr.show("出错");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
            //清理activity对象
            presenter.clearRxActivity();
        }
        presenter=null;
        AppManager.getInstance().finishActivity(this);
    }

    /**
     * 做一些初始化操作
     * @param savedInstanceState
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 指定需要加载的布局文件
     * @return
     */
    protected abstract int getLayoutRes();
    /**
     * 创建presenter对象
     */
    protected abstract T creatPresenter();
    /**
     * 使用presenter对象
     * @return
     */
    public T getPresnter(){
        return presenter;
    }
}
