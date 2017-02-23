package com.leoliao.everydayweather.utils;

import com.leoliao.everydayweather.Constants;
import com.leoliao.everydayweather.beans.loc.Country;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

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

    public static synchronized void requestCities(String cityCode,AsyncHttpResponseHandler handler){
        new AsyncHttpClient().get(Constants.REQUEST_DOMESTIC_ADDRESS+cityCode,handler);
    }

    public static synchronized void  requestCountries(Country country,AsyncHttpResponseHandler handler){
        new AsyncHttpClient().get(Constants.REQUEST_DOMESTIC_ADDRESS+country.getCityCode()+"/"+country.getCountryCode(),handler);
    }
}
