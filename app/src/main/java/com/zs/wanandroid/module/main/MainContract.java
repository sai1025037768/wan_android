package com.zs.wanandroid.module.main;

import com.zs.wanandroid.base.presenter.AbstractPresenter;
import com.zs.wanandroid.base.view.AbstractView;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/9 11:55
 * @class describe
 */
public class MainContract {

    interface View extends AbstractView{

    }

    interface Presenter extends AbstractPresenter<View>{

    }
}
