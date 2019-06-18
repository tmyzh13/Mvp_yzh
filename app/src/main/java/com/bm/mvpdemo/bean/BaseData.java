package com.bm.mvpdemo.bean;

/**
 * Created by issuser on 2018/3/23.
 */

public class BaseData<T> {

    //接口返回的响应 判断成功或者失败
//    private int retCode;
    private int errorCode;
    //接口返回的错误信息
//    private String msg;
    private String errorMsg;
    //真正的数据
    private T data;
//    private T result;//暂时用这个字段 配合测试接口

    public int getCode() {
        return errorCode;
    }

    public String getMsg() {
        return errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public void setMsg(String msg) {
        this.errorMsg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
