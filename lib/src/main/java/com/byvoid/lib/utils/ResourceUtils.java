package com.byvoid.lib.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import com.byvoid.lib.AndroidLib;

/**
 * @author melody
 * @date 2018/2/8
 */
public class ResourceUtils {

    public static String getString(@StringRes int resId){
        return AndroidLib.getApplication().getString(resId);
    }

    public static int getColor(@ColorRes int resId){
        return ContextCompat.getColor(AndroidLib.getApplication(),resId);
    }

    public static Drawable getDrawable(@DrawableRes int resId){
        return ContextCompat.getDrawable(AndroidLib.getApplication(),resId);
    }

    public static Drawable getDrawable(@NonNull String drawableName){
        Resources resources = AndroidLib.getApplication().getResources();
        int resId = resources.getIdentifier(drawableName,"drawable",AndroidLib.getApplication().getPackageName());
        return getDrawable(resId);
    }


}
