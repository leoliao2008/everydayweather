package com.leoliao.everydayweather.utils;

import android.widget.Toast;

import com.leoliao.everydayweather.base.BaseApplication;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 23:59
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ToastUtil {
    private static Toast mToast;
    public static synchronized void showToast(String msg){
        if(mToast==null){
            mToast=Toast.makeText(BaseApplication.getContext(),msg,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
