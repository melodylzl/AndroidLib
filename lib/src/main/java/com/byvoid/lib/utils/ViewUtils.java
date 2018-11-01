package com.byvoid.lib.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author melody
 * @date 2018/3/21
 */
public class ViewUtils {

    public static boolean refreshHeight(View view, int newHeight){
        if (view.isInEditMode()){
            return false;
        }
        if (view.getHeight() == newHeight){
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null){
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    newHeight);
            view.setLayoutParams(layoutParams);
        }else{
            layoutParams.height = newHeight;
            view.requestLayout();
        }
        return true;
    }

    public static boolean refreshWidth(View view, int newWidth){
        if (view.isInEditMode()){
            return false;
        }
        if (view.getWidth() == newWidth){
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null){
            layoutParams = new ViewGroup.LayoutParams(newWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);
        }else{
            layoutParams.width = newWidth;
            view.requestLayout();
        }
        return true;
    }
}
