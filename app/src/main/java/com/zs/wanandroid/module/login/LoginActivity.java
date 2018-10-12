package com.zs.wanandroid.module.login;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.zs.wanandroid.R;
import com.zs.wanandroid.base.activity.BaseActivity;
import com.zs.wanandroid.utils.CommonUtils;
import com.zs.wanandroid.utils.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/26 17:45
 * @class describe
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.login_group)
    RelativeLayout mLoginGroup;
    @BindView(R.id.login_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.login_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.login_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.login_register_btn)
    Button mRegisterBtn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
//        StatusBarUtil.setPaddingSmart(getApplicationContext(),mToolbar);
        StatusBarUtil.setStatusColor(getWindow(),
                ContextCompat.getColor(this, R.color.white), 1f);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }

    @Override
    protected void initEventAndData() {
        subscribeLoginClickEvent();
    }

    private void subscribeLoginClickEvent() {
        mPresenter.addRxBindingSubscribe(RxView.clicks(mLoginBtn)
            .throttleFirst(5, TimeUnit.SECONDS)
            .filter(new Predicate<Object>() {
                @Override
                public boolean test(Object o) throws Exception {
                    return mPresenter != null;
                }
            })
            .subscribe(new Consumer<Object>() {
                @Override
                public void accept(Object o) throws Exception {
                    mPresenter.userLogin(mAccountEdit.getText().toString().trim(),
                            mPasswordEdit.getText().toString().trim());
                }
            }));
    }

    @Override
    public void showLoginSuccess() {
        CommonUtils.showMessage(this, getString(R.string.login_success));
        onBackPressedSupport();
    }
}
