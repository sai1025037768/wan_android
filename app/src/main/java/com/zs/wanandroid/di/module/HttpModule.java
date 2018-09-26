package com.zs.wanandroid.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zs.wanandroid.core.http.api.GeeksApi;
import com.zs.wanandroid.utils.CommonUtils;
import com.zs.wanandroid.utils.LogHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 19:21
 * @class 网络请求类
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    GeeksApi provideGeeksApi(Retrofit retrofit){
        return retrofit.create(GeeksApi.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        return builder.client(okHttpClient)
                .baseUrl(GeeksApi.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder, Interceptor cacheInterceptor){
        return builder.addInterceptor(new HttpLoggingInterceptor())
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(cacheInterceptor)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkhttpBuilder(){
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    Interceptor provideCacheInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if(!CommonUtils.isNetworkConnected()){
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                    LogHelper.e("无网络");
                }

                Response response = chain.proceed(request);
                if(CommonUtils.isNetworkConnected()){
                    String cacheControl = request.cacheControl().toString();
                    response = response.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .removeHeader("Pragma")
                            .build();
                }else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response = response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }

                return response;
            }
        };
    }




}
