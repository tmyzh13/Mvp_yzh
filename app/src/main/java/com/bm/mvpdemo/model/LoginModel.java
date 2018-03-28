package com.bm.mvpdemo.model;

import android.util.Log;

import com.bm.mvpdemo.api.ApiFactory;
import com.bm.mvpdemo.api.LoginApi;
import com.bm.mvpdemo.base.BaseCallBackNew;
import com.bm.mvpdemo.base.BaseModel;
import com.bm.mvpdemo.bean.UserBean;
import com.bm.mvpdemo.https.ApiMethod;
import com.bm.mvpdemo.https.BaseObserver;
import com.bm.mvpdemo.utils.ApiException;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.Map;

/**
 * Created by john on 2018/3/28.
 */

public class LoginModel implements BaseModel{

    private LoginApi api;

    @Override
    public void getNetApi() {
        api= ApiFactory.getInstance().create(LoginApi.class);
    }

    public void requestPostAPI(RxActivity activity, Map params, final BaseCallBackNew<UserBean> callBack) {
        ApiMethod.getObservable(api.login(params),activity)
                .subscribe(new BaseObserver<UserBean>("login") {

                    @Override
                    protected void onSuccess(UserBean bean) {
                        Log.e("yzh","data--"+bean.toString());
                        callBack.onSuccess(bean);
                    }

                    @Override
                    protected void onFail(ApiException e) {
                        //可以根据不同的code做不同的逻辑处理
                        Log.e("yzh","code--"+e.getCode());
                        callBack.onFailure(e.getCode(),e.getMsg());
                    }

                });
    }
}
