package com.leoliao.everydayweather.activity;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.base.BaseActivity;
import com.leoliao.everydayweather.base.BaseApplication;

public class SplashPage extends BaseActivity {

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash_page;
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApplication.postDelay(new Runnable() {
            @Override
            public void run() {
                MainActivity.startActivity(SplashPage.this);
                finish();
                overridePendingTransition(R.anim.animate_windows_enter,R.anim.animate_windows_exit);
            }
        },500);
    }

}
