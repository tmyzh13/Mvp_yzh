package com.bm.mvpdemo.presenter;

import com.bm.mvpdemo.base.BaseCallBackNew;
import com.bm.mvpdemo.base.BasePresenter;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.model.LoginModel;
import com.bm.mvpdemo.views.interfaces.LoginView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by john on 2018/3/28.
 */

public class LoginPresenter  extends BasePresenter<LoginView> {

    private LoginModel model;

    @Override
    public void onStart() {
        model = new LoginModel();
        model.getNetApi();
    }

    public void login(String login, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", login);
        map.put("password", password);
        map.put("key", "1889b37351288");
        getView().showLoading();
        model.requestPostAPI(activity, map, new BaseCallBackNew<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                getView().hideLoading();
                getView().showUserData(data);
            }

            @Override
            public void onFailure(int code, String msg) {
                //可以判断code做操作
                getView().hideLoading();
                getView().showToast(msg);
            }

        });
    }
}
