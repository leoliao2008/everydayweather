package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 0:51
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class CurrentStatus {
//    "now": {  //实况天气
//        "cond": {  //天气状况
//            "code": "104",  //天气状况代码
//                    "txt": "阴"  //天气状况描述
//        },
//        "fl": "11",  //体感温度
//                "hum": "31",  //相对湿度（%）
//                "pcpn": "0",  //降水量（mm）
//                "pres": "1025",  //气压
//                "tmp": "13",  //温度
//                "vis": "10",  //能见度（km）
//                "wind": {  //风力风向
//            "deg": "40",  //风向（360度）
//                    "dir": "东北风",  //风向
//                    "sc": "4-5",  //风力
//                    "spd": "24"  //风速（kmph）
//        }
//    },
    WeatherCondition cond;
    /**
     * 体感温度
     */
    String fl;
    String hum;
    /**
     * 降水量
     */
    String pcpn;
    String pres;
    String tmp;
    @SerializedName("vis")
    String visibility;
    Wind wind;

    public WeatherCondition getCond() {
        return cond;
    }

    public String getFl() {
        return fl;
    }

    public String getHum() {
        return hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public String getPres() {
        return pres;
    }

    public String getTmp() {
        return tmp;
    }

    public String getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }
}
