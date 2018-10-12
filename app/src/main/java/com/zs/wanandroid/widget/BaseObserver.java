package com.zs.wanandroid.widget;

import android.text.TextUtils;

import com.zs.wanandroid.R;
import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.base.view.AbstractView;
import com.zs.wanandroid.core.http.exception.ServerException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/27 13:31
 * @class describe
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private AbstractView mView;

    private String mErrorMsg;

    private boolean isShowError = true;

    public BaseObserver(AbstractView mView) {
        this.mView = mView;
    }

    public BaseObserver(AbstractView mView, String mErrorMsg) {
        this.mView = mView;
        this.mErrorMsg = mErrorMsg;
    }

    public BaseObserver(AbstractView mView, boolean isShowError) {
        this.mView = mView;
        this.isShowError = isShowError;
    }

    public BaseObserver(AbstractView mView, String mErrorMsg, boolean isShowError) {
        this.mView = mView;
        this.mErrorMsg = mErrorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onError(Throwable e) {
        if(mView == null){
            return;
        }

        if(!TextUtils.isEmpty(mErrorMsg)){
            mView.showErrorMsg(mErrorMsg);
        }else if(e instanceof ServerException){
            mView.showErrorMsg(e.toString());
        }else if(e instanceof HttpException){
            mView.showErrorMsg(WanAndroidApp.getInstance().getString(R.string.http_error));
        }

        if(isShowError){
            mView.showError();
        }

    }

    @Override
    public void onComplete() {

    }
}
