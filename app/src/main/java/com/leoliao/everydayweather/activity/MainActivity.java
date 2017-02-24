package com.leoliao.everydayweather.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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
public class MainActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            showLog("action bar is not null");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }else {
            showLog("action bar is null");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START,true);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void initViews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        mToolbar= (Toolbar) findViewById(R.id.activity_main_tool_bar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_activity;
    }

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }
}
