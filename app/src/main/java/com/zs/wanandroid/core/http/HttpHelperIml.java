package com.zs.wanandroid.core.http;

import com.zs.wanandroid.core.bean.BaseResponse;
import com.zs.wanandroid.core.bean.login.LoginData;
import com.zs.wanandroid.core.http.api.GeeksApi;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 19:40
 * @class describe
 */
public class HttpHelperIml implements HttpHelper {

    GeeksApi geeksApi;

    @Inject
    public HttpHelperIml(GeeksApi geeksApi){
        this.geeksApi = geeksApi;
    }

    @Override
    public Observable<BaseResponse<LoginData>> userLogin(String username, String password) {
        return geeksApi.userLogin(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> userRegister(String username, String password, String repassword) {
        return geeksApi.userRegister(username, password, repassword);
    }
}
