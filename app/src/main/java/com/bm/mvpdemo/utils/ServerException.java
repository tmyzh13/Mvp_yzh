package com.bm.mvpdemo.utils;

/**
 * 解析服务器返回数据code=失败的情况
 * Created by issuser on 2018/3/26.
 */

public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
