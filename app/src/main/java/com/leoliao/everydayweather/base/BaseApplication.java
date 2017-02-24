package com.leoliao.everydayweather.base;

import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:14
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class BaseApplication extends LitePalApplication {
    private static android.os.Handler handler;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        handler=new android.os.Handler();
        mContext=getApplicationContext();
    }

    public static void postRunnable(Runnable runnable){
        handler.post(runnable);
    }

    public static void postDelay(Runnable runnable,long millis){
        handler.postDelayed(runnable,millis);
    }

    public static Context getGlobalContext(){
        return mContext;
    }
}
