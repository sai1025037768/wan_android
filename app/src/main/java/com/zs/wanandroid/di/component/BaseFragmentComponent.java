package com.zs.wanandroid.di.component;

import com.zs.wanandroid.base.fragment.BaseFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author quchao
 * @date 2018/5/3
 */

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {

    /**
     * 每一个继承于BaseFragment的Fragment都继承于同一个子组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends Builder<BaseFragment>{

    }
}
