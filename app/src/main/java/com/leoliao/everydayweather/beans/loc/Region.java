package com.leoliao.everydayweather.beans.loc;

import org.litepal.crud.DataSupport;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/25 20:55
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Region extends DataSupport {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
