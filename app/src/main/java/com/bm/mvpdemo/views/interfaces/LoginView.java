package com.bm.mvpdemo.views.interfaces;

import com.bm.mvpdemo.base.BaseView;
import com.bm.mvpdemo.bean.UserBean;

/**
 * Created by john on 2018/3/28.
 */

public interface LoginView  extends BaseView{
    void showUserData(UserBean userBean);
}
