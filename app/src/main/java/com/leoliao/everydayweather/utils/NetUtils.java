package com.leoliao.everydayweather.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leoliao.everydayweather.Constants;
import com.leoliao.everydayweather.beans.loc.City;
import com.leoliao.everydayweather.beans.loc.Country;
import com.leoliao.everydayweather.beans.loc.Province;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 1:06
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class NetUtils {
    public static synchronized void requestProvinces(AsyncHttpResponseHandler handler){
        new AsyncHttpClient().get(Constants.REQUEST_DOMESTIC_ADDRESS,handler);
    }

    public static synchronized void requestCities(Province province, AsyncHttpResponseHandler handler){
        new AsyncHttpClient().get(Constants.REQUEST_DOMESTIC_ADDRESS+province.getProvinceCode(),handler);
    }

    public static synchronized void  requestCountries(City city, AsyncHttpResponseHandler handler){
        new AsyncHttpClient().get(Constants.REQUEST_DOMESTIC_ADDRESS+city.getProvinceCode()+"/"+city.getCityCode(),handler);
    }

    public static void requestWallPaper(final Context context, final ImageView imageView){
        new AsyncHttpClient().get(Constants.REQUEST_WALL_PAPER, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Glide.with(context).load(new String(responseBody)).into(imageView);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    public static void requestWeather(Country country, AsyncHttpResponseHandler handler){
        LogUtil.showLog("request weather:",Constants.REQUEST_WEATHER_DATA+country.getWeatherId());
        new AsyncHttpClient().get(Constants.REQUEST_WEATHER_DATA+country.getWeatherId(),handler);
    }

}
