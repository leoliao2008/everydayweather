package com.leoliao.everydayweather.beans.loc;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:45
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class City extends Region {
    private String provinceCode;
    private String provinceName;
    @SerializedName("name")
    private String cityName;
    @SerializedName("id")
    private String cityCode;

    public City(String provinceCode, String provinceName, String cityName, String cityCode) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
