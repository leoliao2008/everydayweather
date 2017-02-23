package com.leoliao.everydayweather.beans.gson;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 0:43
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class HourlyForecast {
//    {
//        "cond": { //天气状况
//        "code": "100",  //天气状况代码
//                "txt": "晴"  //天气状况描述
//    },
//        "date": "2016-08-31 12:00",  //时间
//            "hum": "21",  //相对湿度（%）
//            "pop": "0",  //降水概率
//            "pres": "998",  //气压
//            "tmp": "33",  //温度
//            "wind": {  //风力风向
//        "deg": "40",  //风向（360度）
//                "dir": "东北风",  //风向
//                "sc": "4-5",  //风力
//                "spd": "24"  //风速（kmph）
//    }
//    }
    WeatherCondition cond;
    String date;
    String hum;
    String pop;
    String pres;
    String tmp;
    Wind wind;
}
