package com.zs.wanandroid.module.login;

import com.zs.wanandroid.base.presenter.BasePresenter;
import com.zs.wanandroid.core.DataManager;

import javax.inject.Inject;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/26 17:46
 * @class describe
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void userLogin(String username, String password) {
        mDataManager.userLogin(username, password);
    }
}
