package com.zs.wanandroid.di.module;

import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.core.db.DbHelper;
import com.zs.wanandroid.core.db.DbHelperImpl;
import com.zs.wanandroid.core.http.HttpHelper;
import com.zs.wanandroid.core.http.HttpHelperIml;
import com.zs.wanandroid.core.prefs.PreferenceHelper;
import com.zs.wanandroid.core.prefs.PreferenceHelperImpl;

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
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper){
        return preferenceHelper;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperIml httpHelperIml){
        return httpHelperIml;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferenceHelper preferenceHelper, DbHelper dbHelper){
        return new DataManager(httpHelper, preferenceHelper, dbHelper);
    }
}
