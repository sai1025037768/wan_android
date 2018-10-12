package com.zs.wanandroid.di.module;

import com.zs.wanandroid.module.login.LoginActivity;
import com.zs.wanandroid.module.main.MainActivity;
import com.zs.wanandroid.module.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector
    abstract LoginActivity contributesLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity contributesSplashActivity();

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();
}
