package com.leoliao.everydayweather.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leoliao.everydayweather.R;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:12
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initViews();
        initData();
        initListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.animate_windows_enter,R.anim.animate_windows_exit);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.animate_windows_enter,R.anim.animate_windows_exit);
    }

    protected abstract void initListeners();

    protected abstract void initData();

    protected abstract void initViews();

    protected abstract int setLayoutId();


}
