package com.leoliao.everydayweather.beans.loc;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:47
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Country extends Region {
    @SerializedName("name")
    private String countryName;
    @SerializedName("id")
    private String countryCode;
    private String cityName;
    private String cityCode;
    private String provinceName;
    private String provinceCode;
    @SerializedName("weather_id")
    private String weatherId;

    public Country(String countryName, String countryCode, String cityName, String cityCode, String provinceName, String provinceCode, String weatherId) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.weatherId = weatherId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }
}
