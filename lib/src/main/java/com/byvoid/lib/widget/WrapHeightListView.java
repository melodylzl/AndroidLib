package com.byvoid.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @author melody
 * @date 2018/2/27
 */
public class WrapHeightListView extends ListView{


    public WrapHeightListView(Context context) {
        super(context);
    }

    public WrapHeightListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapHeightListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
