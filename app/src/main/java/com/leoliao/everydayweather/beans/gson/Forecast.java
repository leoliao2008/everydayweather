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
public class Forecast {
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
}
