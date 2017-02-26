package com.leoliao.everydayweather.beans.gson;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/23 0:28
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class AQI {

//    "aqi": {
//        "city": {
//            "aqi": "139",
//                    "co": "1",
//                    "no2": "39",
//                    "o3": "33",
//                    "pm10": "0",
//                    "pm25": "106",
//                    "qlty": "轻度污染",
//                    "so2": "15"
//        }
    City city;

    public City getCity() {
        return city;
    }

    public class City{
    String aqi;
    String co;
    String no2;
    String o3;
    String pm10;
    String pm25;
    String qlty;
    String so2;

        public String getAqi() {
            return aqi;
        }

        public String getCo() {
            return co;
        }

        public String getNo2() {
            return no2;
        }

        public String getO3() {
            return o3;
        }

        public String getPm10() {
            return pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public String getQlty() {
            return qlty;
        }

        public String getSo2() {
            return so2;
        }
    }
}
