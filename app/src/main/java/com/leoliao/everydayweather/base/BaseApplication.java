package com.leoliao.everydayweather.base;

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

    @Override
    public void onCreate() {
        super.onCreate();
        handler=new android.os.Handler();
    }

    public static void postRunnable(Runnable runnable){
        handler.post(runnable);
    }

    public static void postDelay(Runnable runnable,long millis){
        handler.postDelayed(runnable,millis);
    }
}
