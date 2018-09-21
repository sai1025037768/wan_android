package com.zs.wanandroid.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zs.wanandroid.component.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:00
 * @class 通用 activity
 */
public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unbinder;
    private AbstractSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityCollector.getInstance().addActivity(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

    /**
     * 初始化toolbar
     */
    protected abstract void initToolbar();

    /**
     * 布局加载完成
     */
    protected abstract void onViewCreated();

    /**
     * 获取当前activity布局资源
     * @return
     */
    public abstract int getLayoutId();
}
