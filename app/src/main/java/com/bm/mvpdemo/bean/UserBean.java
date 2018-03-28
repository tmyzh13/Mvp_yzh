package com.bm.mvpdemo.bean;

/**
 * Created by issuser on 2018/3/27.
 */

public class UserBean {

    private String token;
    private String uid;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token=token;
    }

    public String getUid(){
        return uid;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "token='" + token + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public void setUid(String uid){
        this.uid=uid;
    }
}
