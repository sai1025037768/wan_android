package com.zs.wanandroid.module.login;

import com.zs.wanandroid.base.presenter.AbstractPresenter;
import com.zs.wanandroid.base.view.AbstractView;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/26 17:42
 * @class describe
 */
public interface LoginContract {

    interface View extends AbstractView{

        void showLoginSuccess();
    }

    interface Presenter extends AbstractPresenter<View>{

        /**
         * Get Login data
         *
         * @param username user name
         * @param password password
         */
        void userLogin(String username, String password);
    }
}
