package com.byvoid.lib.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


/**
 * 高度自适应的ImageView
 * 控件的高=控件的宽/图片的实际宽*图片的实际高
 * @author melody
 * @date 2018/8/7
 */
public class ResizeImageView extends AppCompatImageView {

    public ResizeImageView(Context context) {
        super(context);
    }

    public ResizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        Drawable drawable = getDrawable();
        if (drawable != null){
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) Math.ceil((float) width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
            setMeasuredDimension(width, height);
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
