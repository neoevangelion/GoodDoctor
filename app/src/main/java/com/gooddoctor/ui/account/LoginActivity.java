package com.gooddoctor.ui.account;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.gooddoctor.R;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {
    private WeiboAuth mWeiboAuth;
    private static final String SINA_WEIBO_APP_KEY = "3100159218";
    private static final String SINA_WEIBO_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        mWeiboAuth = new WeiboAuth(this, SINA_WEIBO_APP_KEY, SINA_WEIBO_REDIRECT_URL, null);
    }

    @OnClick(R.id.login_sina_weibo_sso_button) void sinaWeiboLogin() {
        mWeiboAuth.anthorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                Log.i("", bundle.toString());
            }

            @Override
            public void onWeiboException(WeiboException e) {
                e.printStackTrace();
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @OnClick(R.id.login_tencent_sso_button) void tencentQQLogin() {

    }
}
