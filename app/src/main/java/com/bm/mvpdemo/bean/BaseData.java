package com.bm.mvpdemo.bean;

/**
 * Created by issuser on 2018/3/23.
 */

public class BaseData<T> {

    //接口返回的响应 判断成功或者失败
    private int retCode;
    //接口返回的错误信息
    private String msg;

    //真正的数据
//    private T data;
    private T result;//暂时用这个字段 配合测试接口

    public int getCode() {
        return retCode;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return result;
    }

    public void setCode(int code) {
        this.retCode = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.result = data;
    }
}
