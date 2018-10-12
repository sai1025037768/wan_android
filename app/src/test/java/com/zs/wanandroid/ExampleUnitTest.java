package com.zs.wanandroid;

import android.app.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(ProxyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testResource(){
        Application application = RuntimeEnvironment.application;
        System.out.println(application.getString(R.string.account_password_null_tint));
    }
}