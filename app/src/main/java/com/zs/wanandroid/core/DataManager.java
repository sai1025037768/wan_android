package com.zs.wanandroid.core;

import com.zs.wanandroid.core.bean.BaseResponse;
import com.zs.wanandroid.core.bean.login.LoginData;
import com.zs.wanandroid.core.dao.HistoryData;
import com.zs.wanandroid.core.db.DbHelper;
import com.zs.wanandroid.core.http.HttpHelper;
import com.zs.wanandroid.core.prefs.PreferenceHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:33
 * @class describe
 */
public class DataManager implements HttpHelper, PreferenceHelper, DbHelper{
    private HttpHelper mHttpHelper;
    private PreferenceHelper mPreferenceHelper;
    private DbHelper mDbHelper;
    private boolean loginStatus;
    private String loginAccount;
    private String loginPassword;
    private int currentPage;

    public DataManager(HttpHelper httpHelper, PreferenceHelper preferenceHelper, DbHelper dbHelper) {
        this.mHttpHelper = httpHelper;
        this.mPreferenceHelper = preferenceHelper;
        this.mDbHelper = dbHelper;
    }


    @Override
    public List<HistoryData> addHistoryData(String data) {
        return mDbHelper.addHistoryData(data);
    }

    @Override
    public void clearHistoryData() {
        mDbHelper.clearHistoryData();
    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return mDbHelper.loadAllHistoryData();
    }

    @Override
    public Observable<BaseResponse<LoginData>> userLogin(String username, String password) {
        return mHttpHelper.userLogin(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> userRegister(String username, String password, String repassword) {
        return mHttpHelper.userRegister(username, password, repassword);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferenceHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferenceHelper.getLoginPassword();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }

    @Override
    public void setCookie(String domain, String cookie) {
        mPreferenceHelper.setCookie(domain, cookie);
    }

    @Override
    public String getCookie(String domain) {
        return mPreferenceHelper.getCookie(domain);
    }

    @Override
    public void setCurrentPage(int position) {
        mPreferenceHelper.setCurrentPage(position);
    }

    @Override
    public int getCurrentPage() {
        return mPreferenceHelper.getCurrentPage();
    }

    @Override
    public void setProjectCurrentPage(int position) {
        mPreferenceHelper.setProjectCurrentPage(position);
    }

    @Override
    public int getProjectCurrentPage() {
        return mPreferenceHelper.getProjectCurrentPage();
    }

    @Override
    public boolean getAutoCacheState() {
        return mPreferenceHelper.getAutoCacheState();
    }

    @Override
    public boolean getNoImageState() {
        return mPreferenceHelper.getNoImageState();
    }

    @Override
    public boolean getNightModeState() {
        return mPreferenceHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferenceHelper.setNightModeState(b);
    }

    @Override
    public void setNoImageState(boolean b) {
        mPreferenceHelper.setNoImageState(b);
    }

    @Override
    public void setAutoCacheState(boolean b) {
        mPreferenceHelper.setAutoCacheState(b);
    }
}
