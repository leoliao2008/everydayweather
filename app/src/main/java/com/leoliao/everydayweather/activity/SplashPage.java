package com.leoliao.everydayweather.activity;

import android.view.View;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.base.BaseActivity;
import com.leoliao.everydayweather.base.BaseApplication;

public class SplashPage extends BaseActivity {

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

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
            }
        },2000);
    }

}
