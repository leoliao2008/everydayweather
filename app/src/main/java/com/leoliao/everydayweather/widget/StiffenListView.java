package com.leoliao.everydayweather.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/26 0:03
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class StiffenListView extends ListView {
    public StiffenListView(Context context) {
        super(context);
    }

    public StiffenListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StiffenListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
