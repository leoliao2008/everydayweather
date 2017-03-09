package com.leoliao.everydayweather.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
import com.leoliao.everydayweather.widget.ScreenBlocker;
import com.leoliao.everydayweather.widget.StiffenListView;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;

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
    private StiffenListView lstv_dailyForecast;
    private ArrayList<DailyForecast>mDailyForecasts=new ArrayList<>();
    private ForecastListAdapter mForecastListAdapter;
    private TextView tv_currentTemp;
    private TextView tv_currentWeatherDsr;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ScreenBlocker mScreenBlocker;
    private TextView tv_aqi;
    private TextView tv_pm25;
    private StiffenListView lstv_suggestions;
    private ArrayList<String> suggestionList=new ArrayList<>();
    private ArrayAdapter<String> mSuggestionsAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private NestedScrollView mNestedScrollView;
    private Country currentRegion;
    private String mWeatherId;
    private SharedPreferences mSharedPreferences;
    private AppBarLayout mAppBarLayout;
    private String string_expandedTitle;
    private String string_collapsedTitle;
    private SharedPreferences mWeatherCache;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main_activity;
    }

    @Override
    protected void initViews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        mToolbar= (Toolbar) findViewById(R.id.activity_main_tool_bar);
        iv_wallPaper= (ImageView) findViewById(R.id.main_iv_wall_paper);
        lstv_dailyForecast = (StiffenListView) findViewById(R.id.main_lsv_forecast);
        tv_currentTemp= (TextView) findViewById(R.id.main_tv_current_temperature);
        tv_currentWeatherDsr= (TextView) findViewById(R.id.main_tv_current_weather_description);
        mCollapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.main_collapsing_tool_bar);
        mScreenBlocker= (ScreenBlocker) findViewById(R.id.main_loading_view);
        tv_aqi= (TextView) findViewById(R.id.main_tv_aqi);
        tv_pm25= (TextView) findViewById(R.id.main_tv_pm2_5);
        lstv_suggestions= (StiffenListView) findViewById(R.id.main_lsv_suggestions);
        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.main_swipe_refresh_layout);
        mNestedScrollView= (NestedScrollView) findViewById(R.id.main_nested_scroll_view);
        mAppBarLayout= (AppBarLayout) findViewById(R.id.main_app_bar_layout);
    }

    @Override
    protected void initData() {
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        mSupportActionBar = getSupportActionBar();
        mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));
        if(mSupportActionBar != null){
            mSupportActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE|ActionBar.DISPLAY_HOME_AS_UP);
            mSupportActionBar.setHomeAsUpIndicator(R.drawable.selector_btn_pinpoint);
        }
        NetUtils.requestWallPaper(this,iv_wallPaper);
        mForecastListAdapter=new ForecastListAdapter(this,mDailyForecasts);
        lstv_dailyForecast.setAdapter(mForecastListAdapter);

        mSuggestionsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,suggestionList){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv= (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.WHITE);
                int padding = getResources().getDimensionPixelOffset(R.dimen.padding_medium);
                tv.setPadding(padding,padding,padding,padding);
                return tv;
            }
        };
        lstv_suggestions.setAdapter(mSuggestionsAdapter);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.BLUE);
        mSharedPreferences = getSharedPreferences("current_weather_id", Context.MODE_PRIVATE);
        mWeatherId = mSharedPreferences.getString("weather_id", "CN101280601");
        List<Country> countries = DataSupport.where("weatherId=?", mWeatherId).find(Country.class);
        if(countries.size()>0){
            currentRegion=countries.get(0);
            showLog("request weather:"+currentRegion.getCityName());
            updateWeather(currentRegion);
        }
        //        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//            checkPermissions();
//        }
//        getBDLocation();
    }


    @Override
    protected void initListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(currentRegion!=null){
//                    updateWeather(currentRegion);
                    requestWeatherByNet(currentRegion);
                }else {
                    ToastUtil.showToast("请先设置当前城市。");
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(verticalOffset==0){
                    if(!TextUtils.isEmpty(string_collapsedTitle)){
                        mCollapsingToolbarLayout.setTitleEnabled(true);
                        mCollapsingToolbarLayout.setTitle(string_collapsedTitle);
                    }
                }else if(Math.abs(verticalOffset)==mAppBarLayout.getTotalScrollRange()){
                    if(!TextUtils.isEmpty(string_expandedTitle)){
                        mCollapsingToolbarLayout.setTitleEnabled(true);
                        mCollapsingToolbarLayout.setTitle(string_expandedTitle);
                    }
                }
            }
        });



    }



    public static void startActivity(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START, true);
                break;
            default:
                break;
        }
        return true;
    }

    public void closeDrawer(){
        mDrawerLayout.closeDrawer(GravityCompat.START,true);
    }

    public void updateWeather(final Country country){
        currentRegion=country;
        mSharedPreferences.edit().putString("weather_id",country.getWeatherId()).apply();
        mWeatherCache = getSharedPreferences("WeatherDataCache", MODE_PRIVATE);
        String dataCacheString = mWeatherCache.getString(country.getWeatherId(), null);
        if(!TextUtils.isEmpty(dataCacheString)){
            showLog(dataCacheString);
            showLog("weather data cache found...");
            try {
                String string = new JSONObject(dataCacheString).getJSONArray("HeWeather").getJSONObject(0).toString();
                Weather weather = new Gson().fromJson(string, Weather.class);
                if(weather!=null){
                    String localTime = weather.getBasic().getUpdateTime().getLocalTime();
//                    2017-03-05 23:49
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    Date date = sdf.parse(localTime);
                    Date currentDate=new Date();
                    if(currentDate.getTime()-date.getTime()<1000*60*60*8){
                        showLog("use cache");
                         updateUi(weather);
                    }else {
                        showLog("cache out date,use net");
                        requestWeatherByNet(country);
                    }
                }else {
                    showLog("weather is null");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                showLog("JSONException");
                requestWeatherByNet(country);
            } catch (ParseException e) {
                e.printStackTrace();
                showLog("ParseException");
                requestWeatherByNet(country);

            }
        }else {
            requestWeatherByNet(country);
        }

    }

    private void requestWeatherByNet(Country country) {
        NetUtils.requestWeather(country, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                if(!mSwipeRefreshLayout.isRefreshing()){
                    mScreenBlocker.setVisibility(View.VISIBLE);
                }
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                showLog(new String(responseBody));
                try {
                    String s = new JSONObject(new String(responseBody)).getJSONArray("HeWeather").getJSONObject(0).toString();
                    Weather weather = new Gson().fromJson(s, Weather.class);
                    if(weather!=null){
                        updateUi(weather);
                        mWeatherCache.edit().putString(weather.getBasic().getWeatherId(),s).apply();
                    }else {
                        ToastUtil.showToast("更新天气失败。");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ToastUtil.showToast("获取天气情况失败，请检查网络。");

            }

            @Override
            public void onFinish() {
                mSwipeRefreshLayout.setRefreshing(false);
                mScreenBlocker.setVisibility(View.GONE);
                super.onFinish();
            }
        });

    }

    private void updateUi(Weather weather) {
        List<DailyForecast> dailyForecasts = weather.getDailyForecasts();
        if(dailyForecasts!=null){
            mDailyForecasts.clear();
            mDailyForecasts.addAll(dailyForecasts);
            mForecastListAdapter.notifyDataSetChanged();
        }
        tv_currentTemp.setText(weather.getCurrentStatus().getTmp()+"℃");
        tv_currentWeatherDsr.setText(weather.getCurrentStatus().getCond().getDescription());
        string_collapsedTitle=weather.getBasic().getCity();
        string_expandedTitle=weather.getBasic().getCity()+" "+weather.getCurrentStatus().getTmp()+"℃";
        if(weather.getAqi()!=null){
            tv_aqi.setText(weather.getAqi().getCity().getAqi());
            tv_pm25.setText(weather.getAqi().getCity().getPm25());
        }else {
            tv_aqi.setText("无数据");
            tv_pm25.setText("无数据");
        }
        List<String> sl = weather.getSuggestions().getSuggestionList();
        if(suggestionList!=null){
            suggestionList.clear();
            suggestionList.addAll(sl);
            mSuggestionsAdapter.notifyDataSetChanged();
        }
        ToastUtil.showToast("更新天气成功。");

    }

    //    private void getBDLocation(){
//        mLocationClient = new LocationClient(getApplicationContext());
//        initLocation();
//        mLocationClient.registerLocationListener(new BDLocationListener() {
//
//            @Override
//            public void onReceiveLocation(BDLocation bdLocation) {
//                mLocationClient.unRegisterLocationListener(this);
//                mLocationClient.stop();
//                if(bdLocation!=null){
//                    bdLocation.getCity();
//                    bdLocation.getCityCode();
//                    showLog("city:"+bdLocation.getCity());
//                    showLog("city code"+bdLocation.getCityCode());
//                    showLog("district:"+bdLocation.getDistrict());
//                    showLog("country:"+bdLocation.getCountry());
//                }
//            }
//
//            @Override
//            public void onConnectHotSpotMessage(String s, int i) {
//
//            }
//
//        });
//        mLocationClient.start();
//    }

//    private void initLocation(){
//        LocationClientOption option = new LocationClientOption();
//        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
//
//        option.setCoorType("bd09ll");
//        //可选，默认gcj02，设置返回的定位结果坐标系
//
//        int span=1000;
//        option.setScanSpan(span);
//        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
//
//        option.setIsNeedAddress(true);
//        //可选，设置是否需要地址信息，默认不需要
//
//        option.setOpenGps(true);
//        //可选，默认false,设置是否使用gps
//
//        option.setLocationNotify(true);
//        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
//
//        option.setIsNeedLocationDescribe(true);
//        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
//
//        option.setIsNeedLocationPoiList(true);
//        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
//
//        option.setIgnoreKillProcess(false);
//        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
//
//        option.SetIgnoreCacheException(false);
//        //可选，默认false，设置是否收集CRASH信息，默认收集
//
//        option.setEnableSimulateGps(false);
//        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
//
//        mLocationClient.setLocOption(option);
//    }



    private ArrayList<String>permissionList=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermissions(){
        String[] pm=new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                 Manifest.permission.ACCESS_FINE_LOCATION,
                                 Manifest.permission.READ_EXTERNAL_STORAGE,
                                 Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                 Manifest.permission.INTERNET,
                                 Manifest.permission.READ_PHONE_STATE};
        permissionList.clear();
        int len=0;
        for(String s:pm){
            if(checkSelfPermission(s) == PackageManager.PERMISSION_DENIED){
                permissionList.add(s);
                len++;
            }
        }
        String[] pmToRequest=new String[len];
        permissionList.toArray(pmToRequest);
        if(pmToRequest.length>0){
            requestPermissions(pmToRequest, 100);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean isGranted=true;
        if(requestCode==100){
            for(int i:grantResults){
                if(i==PackageManager.PERMISSION_DENIED){
                    isGranted=false;
                }
            }
        }
        if(!isGranted){
            checkPermissions();
        }
    }
}
