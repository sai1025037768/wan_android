package com.zs.wanandroid.base.presenter;

import com.zs.wanandroid.base.view.AbstractView;

import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:26
 * @class describe
 */
public interface AbstractPresenter<T extends AbstractView> {

    /**
     *注入view
     * @param view
     */
    void attachView(T view);

    /**
     * 回收view
     * @param view
     */
    void detachView(T view);

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);


    /**
     * Set login status
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * Set login status
     *
     * @param account account
     */
    void setLoginAccount(String account);

    /**
     * Set login password
     *
     * @param password password
     */
    void setLoginPassword(String password);

    /**
     * Get current page
     *
     * @return current page
     */
    int getCurrentPage();
}
