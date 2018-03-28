package com.bm.mvpdemo.views;

import android.os.Bundle;

import com.bm.mvpdemo.R;
import com.bm.mvpdemo.base.BaseActivity;
import com.bm.mvpdemo.base.BasePresenter;
import com.bm.mvpdemo.base.BaseView;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.presenter.LoginPresenter;
import com.bm.mvpdemo.views.interfaces.LoginView;

import butterknife.OnClick;

/**
 * Created by john on 2018/3/28.
 */

public class LoginActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{

    @Override
    public void showUserData(UserBean userBean) {

    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter creatPresenter() {
        return new LoginPresenter();
    }

    @OnClick(R.id.tv_login)
    public void login(){
        presenter.login("1231231","23123123123");
    }
}
