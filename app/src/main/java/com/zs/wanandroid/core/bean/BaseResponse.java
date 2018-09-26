package com.zs.wanandroid.core.bean;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 18:43
 * @class describe
 */
public class BaseResponse<T> {

    private static final int SUCCESS = 0;

    private static final int FAILURE = 1;


    /**
     * 成功为0，错误为-1
     */
    private int errorCode;

    private String errorMsg;

    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
