package com.leoliao.everydayweather.activity;

import android.content.Context;
import android.content.Intent;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.base.BaseActivity;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 1:56
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class FrontPage extends BaseActivity {
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
        return R.layout.activity_front_page;
    }

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,FrontPage.class));
    }
}
