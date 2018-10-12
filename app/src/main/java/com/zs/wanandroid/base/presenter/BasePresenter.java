package com.zs.wanandroid.base.presenter;

import com.zs.wanandroid.base.view.AbstractView;
import com.zs.wanandroid.core.DataManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:30
 * @class describe
 */
public class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {
    private DataManager mDataManager;
    protected T mView;
    private CompositeDisposable compositeDisposable;

    public BasePresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView(T view) {
        this.mView = null;

        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }

    protected void addSubscribe(Disposable disposable) {
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }

        compositeDisposable.add(disposable);
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {
        mDataManager.setLoginStatus(loginStatus);
    }

    @Override
    public boolean getLoginStatus() {
        return mDataManager.getLoginStatus();
    }

    @Override
    public String getLoginAccount() {
        return mDataManager.getLoginAccount();
    }

    @Override
    public void setLoginAccount(String account) {
        mDataManager.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mDataManager.setLoginPassword(password);
    }

    @Override
    public int getCurrentPage() {
        return mDataManager.getCurrentPage();
    }


}
