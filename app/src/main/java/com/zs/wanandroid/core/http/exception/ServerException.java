package com.zs.wanandroid.core.http.exception;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/27 19:27
 * @class describe
 */
public class ServerException extends Exception {

    private int code;

    public ServerException(String message){
        super(message);
    }

    public ServerException(String message , int code){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
