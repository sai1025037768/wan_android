package com.zs.wanandroid.module.splash;

import com.zs.wanandroid.base.presenter.AbstractPresenter;
import com.zs.wanandroid.base.view.AbstractView;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/8 15:47
 * @class describe
 */
public class SplashContract {

    interface View extends AbstractView {

        void jumpToMain();
    }

    interface Presenter extends AbstractPresenter<View> {}
}
