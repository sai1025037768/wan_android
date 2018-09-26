package com.zs.wanandroid.di.module;

import com.zs.wanandroid.di.component.BaseActivityComponent;
import com.zs.wanandroid.module.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector
    abstract LoginActivity contributesLoginActivity();
}
