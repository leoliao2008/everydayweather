package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/23 0:14
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Weather {
    AQI aqi;
    Basic basic;
    @SerializedName("daily_forecast")
    List<DailyForecast> mDailyForecasts;
    @SerializedName("hourly_forecast")
    List<HourlyForecast> mHourlyForecasts;
    @SerializedName("now")
    CurrentStatus mCurrentStatus;
    String status;
    @SerializedName("suggestion")
    Suggestions mSuggestions;

}
