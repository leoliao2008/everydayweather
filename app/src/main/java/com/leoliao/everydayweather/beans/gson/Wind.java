package com.leoliao.everydayweather.beans.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 0:41
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Wind {
//    "wind": {   //风力风向
        //            "deg": "342",   //风向（360度）
        //                    "dir": "北风",  //风向
        //                    "sc": "3-4",   //风力等级
        //                    "spd": "10"   //风速（kmph）
        //        }
        @SerializedName("deg")
        String degree;
        @SerializedName("dir")
        String direction;
        @SerializedName("sc")
        String level;
        @SerializedName("spd")
        String speed;
}
