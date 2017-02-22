package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/23 0:32
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Basic {
//    "city": "苏州",
//            "cnty": "中国",
//            "id": "CN101190401",
//            "lat": "31.309000",
//            "lon": "120.612000",
//            "update": {
//        "loc": "2017-02-22 23:51",
//                "utc": "2017-02-22 15:51"
//    }
    String city;
    @SerializedName("cnty")
    String county;
    @SerializedName("id")
    String weatherId;
    String lat;
    String lon;
    @SerializedName("update")
    Update updateTime;
    public class Update{
        @SerializedName("loc")
        String localTime;
        @SerializedName("utc")
        String utcTime;
    }

}
