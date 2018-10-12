package com.zs.wanandroid.core.event;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/9 18:33
 * @class describe
 */
public class LoginEvent {
    private boolean isLogined;

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }

    public LoginEvent(boolean isLogined) {
        this.isLogined = isLogined;
    }
}
