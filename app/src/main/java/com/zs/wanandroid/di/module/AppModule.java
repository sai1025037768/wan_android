package com.zs.wanandroid.di.module;

import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.core.db.DbHelper;
import com.zs.wanandroid.core.db.DbHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final WanAndroidApp application;

    public AppModule(WanAndroidApp application){
        this.application = application;
    }

    @Provides
    @Singleton
    WanAndroidApp provideApplicationContext(){
        return application;
    }


    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl realmHelper){
        return realmHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(){
        return new DataManager();
    }
}
