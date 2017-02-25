package com.leoliao.everydayweather.beans.loc;

import com.google.gson.annotations.SerializedName;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:43
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Province extends Region {
    @SerializedName("name")
    private String provinceName;
    @SerializedName("id")
    private String provinceCode;

    public Province(String provinceName, String provinceCode) {
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
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
}
