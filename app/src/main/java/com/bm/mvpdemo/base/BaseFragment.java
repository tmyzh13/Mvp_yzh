package com.bm.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bm.mvpdemo.R;
import com.gyf.barlibrary.ImmersionBar;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/3/28.
 */

public abstract class BaseFragment<V extends BaseView,T extends BasePresenter>
        extends RxFragment implements BaseView {

    private View parenteView;
    protected T presenter;
    private Unbinder mUnbinder = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parenteView = LayoutInflater.from(getActivity()).inflate(getLayoutId(), null, false);
        presenter=createPresenter();
        if(presenter!=null){
            presenter.attachView((V)this);
            presenter.setRxActivity((RxFragmentActivity) getActivity());
        }
        mUnbinder=ButterKnife.bind(this,parenteView);
        init(savedInstanceState);
        if(presenter!=null){
            presenter.onStart();
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (parenteView == null)
            parenteView = inflater.inflate(getLayoutId(), null, false);
        return parenteView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (presenter != null){
            presenter.detachView();
            presenter.clearRxActivity();
        }
        presenter = null;
        mUnbinder.unbind();
    }
    public T getPresenter() {
        return presenter;
    }

    public View getParentView() {
        return parenteView;
    }
    /**
     * 指定Fragment需加载的布局ID
     *
     * @return 需加载的布局ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化方法, 类似OnCreate, 仅在此方法中做初始化操作, findView与事件绑定请使用ButterKnife
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 创建Presenter, 然后通过调用{@link #getPresenter()}来使用生成的Presenter
     * @return Presenter
     */
    protected abstract T createPresenter();
    @Override
    public void showLoading() {
        if (getActivity() instanceof BaseActivity) ((BaseActivity)getActivity()).showLoading();
    }

    @Override
    public void hideLoading() {
        if(getActivity() instanceof BaseActivity){
            ((BaseActivity) getActivity()).hideLoading();
        }
    }



    @Override
    public void showToast(String msg) {
        if(getActivity() instanceof BaseActivity){
            ((BaseActivity)getActivity()).showToast(msg);
        }
    }

    @Override
    public void showErr() {
        if(getActivity() instanceof BaseActivity){
            ((BaseActivity)getActivity()).showErr();
        }
    }

}
