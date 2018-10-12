package com.zs.wanandroid.module.login;

import android.text.TextUtils;

import com.zs.wanandroid.R;
import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.base.presenter.BasePresenter;
import com.zs.wanandroid.component.RxBus;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.core.bean.login.LoginData;
import com.zs.wanandroid.core.event.LoginEvent;
import com.zs.wanandroid.utils.RxUtils;
import com.zs.wanandroid.widget.BaseObserver;

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
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.account_password_null_tint));
        }

        addSubscribe(mDataManager.userLogin(username, password)
                    .compose(RxUtils.rxSchedulerHelper())
                    .compose(RxUtils.handleResult())
                    .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.login_fail)) {
                        @Override
                        public void onNext(LoginData loginData) {
                            setLoginAccount(loginData.getUsername());
                            setLoginPassword(loginData.getPassword());
                            setLoginStatus(true);
                            RxBus.getDefault().post(new LoginEvent(true));
                            mView.showLoginSuccess();
                        }
                    }));

    }
}
