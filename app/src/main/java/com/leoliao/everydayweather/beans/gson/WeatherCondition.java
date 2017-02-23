package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 0:49
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class WeatherCondition {
    String code;
    @SerializedName("txt")
    String description;
}
