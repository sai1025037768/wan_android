package com.zs.wanandroid.presenter;

import com.zs.wanandroid.BuildConfig;
import com.zs.wanandroid.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/27 9:16
 * @class describe
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class LoginPresenterTest extends BasePresenterTest {

    @Test
    public void noInputUsernameOrPassword(){
        mLoginPresenter.userLogin("","");
        Mockito.verify(mView).showSnackBar(mApplication.getString(R.string.account_password_null_tint));
    }

    @Test
    public void inputErrorUsernameOrPassword(){
        mLoginPresenter.userLogin("1025037768","12345");
        Mockito.verify(mView).showErrorMsg(mApplication.getString(R.string.login_fail));
        Mockito.verify(mView).showError();
    }

    @Test
    public void inputCorrectUsernameOrPassword(){
        login();
        Mockito.verify(mView).showLoginSuccess();
    }
}
