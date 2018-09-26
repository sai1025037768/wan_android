package com.zs.wanandroid.di.component;


import com.zs.wanandroid.app.WanAndroidApp;
import com.zs.wanandroid.core.DataManager;
import com.zs.wanandroid.di.module.AbstractAllActivityModule;
import com.zs.wanandroid.di.module.AppModule;
import com.zs.wanandroid.di.module.HttpModule;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AppModule.class,
        HttpModule.class
        })
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param wanAndroidApp WanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    WanAndroidApp getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
