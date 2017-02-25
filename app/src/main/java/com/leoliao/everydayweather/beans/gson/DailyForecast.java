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

    String date;
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

        public int getDayTimeConditionCode() {
            return dayTimeConditionCode;
        }

        public void setDayTimeConditionCode(int dayTimeConditionCode) {
            this.dayTimeConditionCode = dayTimeConditionCode;
        }

        public int getNightTimeConditionCode() {
            return nightTimeConditionCode;
        }

        public void setNightTimeConditionCode(int nightTimeConditionCode) {
            this.nightTimeConditionCode = nightTimeConditionCode;
        }

        public String getDayTimeDescription() {
            return dayTimeDescription;
        }

        public void setDayTimeDescription(String dayTimeDescription) {
            this.dayTimeDescription = dayTimeDescription;
        }

        public String getNightTimeDescription() {
            return nightTimeDescription;
        }

        public void setNightTimeDescription(String nightTimeDescription) {
            this.nightTimeDescription = nightTimeDescription;
        }
    }

    Temperature tmp;
    public class Temperature{
        String max;
        String min;

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }
    }

    Wind wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public AstroDigits getAstroDigits() {
        return mAstroDigits;
    }

    public void setAstroDigits(AstroDigits astroDigits) {
        mAstroDigits = astroDigits;
    }

    public WeatherCondition getWeatherCondition() {
        return mWeatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        mWeatherCondition = weatherCondition;
    }

    public Temperature getTmp() {
        return tmp;
    }

    public void setTmp(Temperature tmp) {
        this.tmp = tmp;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
