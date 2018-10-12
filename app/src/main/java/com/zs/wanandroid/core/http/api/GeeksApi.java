package com.zs.wanandroid.core.http.api;

import com.zs.wanandroid.core.bean.BaseResponse;
import com.zs.wanandroid.core.bean.login.LoginData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 19:05
 * @class describe
 */
public interface GeeksApi {

    String HOST = "http://www.wanandroid.com";

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/user/login")
    Observable<BaseResponse<LoginData>> userLogin(@Field("username") String username,
                                                  @Field("password") String password);

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @FormUrlEncoded
    @POST("/user/register")
    Observable<BaseResponse<LoginData>> userRegister(@Field("username") String username,
                                                     @Field("password") String password,
                                                     @Field("repassword") String repassword);
}
