package com.zs.wanandroid.presenter;

import android.app.Application;

import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.module.login.LoginContract;
import com.zs.wanandroid.module.login.LoginPresenter;
import com.zs.wanandroid.rule.MyRule;
import com.zs.wanandroid.rule.RxJavaRule;
import com.zs.wanandroid.rule.RxJavaSchedulerRule;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class BasePresenterTest {

    @Rule
    MyRule myRule = new MyRule();

    @Rule
    RxJavaRule rxJavaRule = new RxJavaRule();

    @Rule
    RxJavaSchedulerRule rxJavaSchedulerRule = new RxJavaSchedulerRule();

    @Rule
    MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    protected LoginContract.View mView;

    protected LoginPresenter mPresenter;
    private Application mApplication;
    private DataManager mDataManager;
    private LoginPresenter mLoginPresenter;

    @Before
    public void setup(){
        ShadowLog.stream = System.out;
        mApplication = RuntimeEnvironment.application;
        mDataManager = WanAndroidApp.getAppComponent().getDataManager();

        mLoginPresenter = new LoginPresenter(mDataManager);
        mLoginPresenter.attachView(mView);
    }

    public void login(){
        mLoginPresenter.userLogin("1025037768@qq.com", "sai20090360331");
    }
}
