package com.zs.wanandroid.core;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:33
 * @class describe
 */
public class DataManager {
    private boolean loginStatus;
    private String loginAccount;
    private String loginPassword;
    private int currentPage;

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
