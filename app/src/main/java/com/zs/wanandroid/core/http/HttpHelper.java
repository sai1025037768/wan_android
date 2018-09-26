package com.zs.wanandroid.core.http;

import com.zs.wanandroid.core.bean.BaseResponse;
import com.zs.wanandroid.core.bean.login.LoginData;

import io.reactivex.Observable;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 19:21
 * @class describe
 */
public interface HttpHelper {

    Observable<BaseResponse<LoginData>> userLogin(String username,
                                                  String password);

    Observable<BaseResponse<LoginData>> userRegister(String username,
                                                     String password,
                                                     String repassword);


}
