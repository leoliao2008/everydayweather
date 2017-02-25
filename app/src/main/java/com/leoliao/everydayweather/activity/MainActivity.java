package com.leoliao.everydayweather.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.adapters.ForecastListAdapter;
import com.leoliao.everydayweather.base.BaseActivity;
import com.leoliao.everydayweather.beans.gson.DailyForecast;
import com.leoliao.everydayweather.beans.gson.Weather;
import com.leoliao.everydayweather.beans.loc.Country;
import com.leoliao.everydayweather.utils.NetUtils;
import com.leoliao.everydayweather.utils.ToastUtil;
import com.leoliao.everydayweather.widget.StiffenListView;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

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
    private ActionBar mSupportActionBar;
    private ImageView iv_wallPaper;
    private StiffenListView lstv_DailyForecast;
    private ArrayList<DailyForecast>mDailyForecasts=new ArrayList<>();
    private ForecastListAdapter mForecastListAdapter;
    private ProgressBar pgsb_loading;
    private TextView tv_currentTemp;
    private TextView tv_currentWeatherDsr;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        mSupportActionBar = getSupportActionBar();
        if(mSupportActionBar != null){
            mSupportActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE|ActionBar.DISPLAY_HOME_AS_UP);
        }
        NetUtils.requestWallPaper(this,iv_wallPaper);
        mForecastListAdapter=new ForecastListAdapter(this,mDailyForecasts);
        lstv_DailyForecast.setAdapter(mForecastListAdapter);

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

    public void closeDrawer(){
        mDrawerLayout.closeDrawer(GravityCompat.START,true);
    }

    public void updateWeather(Country country){
        mSupportActionBar.setTitle(country.getCountryName());
        NetUtils.requestWeather(country, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                pgsb_loading.setVisibility(View.VISIBLE);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                showLog(new String(responseBody));
                try {
                    String s = new JSONObject(new String(responseBody)).getJSONArray("HeWeather").getJSONObject(0).toString();
                    Weather weather = new Gson().fromJson(s, Weather.class);
                    if(weather!=null){
                        List<DailyForecast> dailyForecasts = weather.getDailyForecasts();
                        showLog(dailyForecasts.toString());
                        if(dailyForecasts!=null){
                            mDailyForecasts.clear();
                            mDailyForecasts.addAll(dailyForecasts);
                            mForecastListAdapter.notifyDataSetChanged();
                        }

                        tv_currentTemp.setText(weather.getCurrentStatus().getTmp()+"℃");
                        tv_currentWeatherDsr.setText(weather.getCurrentStatus().getCond().getDescription());
                        mCollapsingToolbarLayout.setTitle(weather.getBasic().getCity());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                tv_currentTemp.setText("Error");
                tv_currentWeatherDsr.setText("Error");
                ToastUtil.showToast("获取天气情况失败，请检查网络。");

            }

            @Override
            public void onFinish() {
                pgsb_loading.setVisibility(View.GONE);
                super.onFinish();
            }
        });


    }

    @Override
    protected void initViews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        mToolbar= (Toolbar) findViewById(R.id.activity_main_tool_bar);
        iv_wallPaper= (ImageView) findViewById(R.id.main_iv_wall_paper);
        lstv_DailyForecast = (StiffenListView) findViewById(R.id.main_lsv_forecast);
        pgsb_loading= (ProgressBar) findViewById(R.id.main_pgrb_laoding);
        tv_currentTemp= (TextView) findViewById(R.id.main_tv_current_temperature);
        tv_currentWeatherDsr= (TextView) findViewById(R.id.main_tv_current_weather_description);
        mCollapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.main_collapsing_tool_bar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_activity;
    }

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }
}
