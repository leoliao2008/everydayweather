package com.leoliao.everydayweather.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.leoliao.everydayweather.R;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/26 3:06
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ScreenBlocker extends RelativeLayout {
    public ScreenBlocker(Context context) {
        this(context,null);
    }

    public ScreenBlocker(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScreenBlocker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(getResources().getColor(R.color.colorBlackShade));
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

}
