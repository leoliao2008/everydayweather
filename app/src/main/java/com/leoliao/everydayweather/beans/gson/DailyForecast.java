package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/23 0:43
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class DailyForecast {
    String data;
    @SerializedName("hum")
    String humidity;
    /**
     * 降水量
     */
    String pcpn;
    /**
     * 降水概率
     */
    String pop;
    @SerializedName("pres")
    String pressure;
    @SerializedName("astro")
    AstroDigits mAstroDigits;
    //天文数值
    public class AstroDigits{
//        "astro": {
//            "mr": "03:04",
//                    "ms": "13:49",
//                    "sr": "06:31",
//                    "ss": "17:50"
//        },
        @SerializedName("mr")
        String moonRiseTime;
        @SerializedName("ms")
        String moonSetTime;
        @SerializedName("sr")
        String sunRiseTime;
        @SerializedName("ss")
        String sunSetTime;
    }
    @SerializedName("cond")
    WeatherCondition mWeatherCondition;

    public class WeatherCondition{
//        "cond": {   //天气状况
//            "code_d": "100",   //白天天气状况代码
//                    "code_n": "104",  //夜间天气状况代码
//                    "txt_d": "晴",   //白天天气状况描述
//                    "txt_n": "阴"   //夜间天气状况描述
//        },
        @SerializedName("code_d")
        int dayTimeConditionCode;
        @SerializedName("code_n")
        int nightTimeConditionCode;
        @SerializedName("txt_d")
        String dayTimeDescription;
        @SerializedName("txt_n")
        String nightTimeDescription;
    }

    Temperature tmp;
    public class Temperature{
        String max;
        String min;
    }

    Wind wind;
}
