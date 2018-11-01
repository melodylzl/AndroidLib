package com.byvoid.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * @author melody
 * @date 2018/2/9
 */
public class XWebView extends WebView{


    public XWebView(Context context) {
        super(context);
    }

    public XWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public boolean isTop(){
        return getScrollY() == 0;
    }

    public boolean isBottom(){
        return getScrollY() + 10 >= getContentHeight() * getScale() - getMeasuredHeight();
    }
}
