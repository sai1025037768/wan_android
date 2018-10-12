package com.zs.wanandroid.module.main;

import com.zs.wanandroid.base.presenter.BasePresenter;
import com.zs.wanandroid.component.RxBus;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.core.event.LoginEvent;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/9 12:22
 * @class describe
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

        addSubscribe(RxBus.getDefault()
                .toFlowable(LoginEvent.class)
                .filter(new Predicate<LoginEvent>() {
                    @Override
                    public boolean test(LoginEvent loginEvent) throws Exception {
                        return loginEvent.isLogined();
                    }
                })
                .subscribe(new Consumer<LoginEvent>() {
                    @Override
                    public void accept(LoginEvent loginEvent) throws Exception {
                        mView.showLoginView();
                    }
                }));
    }
}
