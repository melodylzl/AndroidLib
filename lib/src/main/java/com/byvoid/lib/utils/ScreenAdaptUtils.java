package com.byvoid.lib.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import com.byvoid.lib.AndroidLib;

/**
 * 屏幕适配方案
 * 参考：https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 * @author melody
 * @date 2018/8/2
 */
public class ScreenAdaptUtils {

    /**
     * 取消适配
     * @param activity 取消适配的activity
     */
    public static void cancelCustomDensity(@NonNull Activity activity){
        final DisplayMetrics systemDisplayMetrics = Resources.getSystem().getDisplayMetrics();
        final DisplayMetrics appDisplayMetrics = AndroidLib.getApplication().getResources().getDisplayMetrics();
        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = systemDisplayMetrics.density;
        activityDisplayMetrics.scaledDensity = systemDisplayMetrics.scaledDensity;
        activityDisplayMetrics.densityDpi = systemDisplayMetrics.densityDpi;
        appDisplayMetrics.density = systemDisplayMetrics.density;
        appDisplayMetrics.scaledDensity = systemDisplayMetrics.scaledDensity;
        appDisplayMetrics.densityDpi = systemDisplayMetrics.densityDpi;
    }

    /**
     * 适配垂直方向
     * @param activity 适配的activity
     * @param size 美术稿给的高度(扣除状态栏的高度),单位dp
     */
    public static void setCustomDensityVertical(@NonNull Activity activity, int size){
        setCustomDensity(activity,size,true);
    }

    /**
     * 适配水平方向
     * @param activity 适配的activity
     * @param size 美术稿给的宽度,单位dp
     */
    public static void setCustomDensityHorizontal(@NonNull Activity activity, int size){
        setCustomDensity(activity,size,false);
    }

    /**
     * 适配、
     * @param activity 适配的activity
     * @param size 美术稿给的高度(扣除状态栏的高度)或宽度,单位dp
     * @param isVertical 是否适配垂直方向 true 垂直，false 水平
     */
    public static void setCustomDensity(@NonNull Activity activity, int size, boolean isVertical){
        final DisplayMetrics systemDisplayMetrics = Resources.getSystem().getDisplayMetrics();
        final DisplayMetrics appDisplayMetrics = AndroidLib.getApplication().getResources().getDisplayMetrics();
        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        if (isVertical){
            activityDisplayMetrics.density = appDisplayMetrics.heightPixels / (float) size;
        }else{
            activityDisplayMetrics.density = appDisplayMetrics.widthPixels / (float) size;
        }
        activityDisplayMetrics.densityDpi = (int) (160 * activityDisplayMetrics.density);
        activityDisplayMetrics.scaledDensity = activityDisplayMetrics.density * (systemDisplayMetrics.scaledDensity / systemDisplayMetrics.density);

        appDisplayMetrics.density = activityDisplayMetrics.density;
        appDisplayMetrics.scaledDensity = activityDisplayMetrics.scaledDensity;
        appDisplayMetrics.densityDpi = activityDisplayMetrics.densityDpi;
    }

    /**
     * 获取状态栏的高度
     * @return 状态栏的高度
     */
    public static int getStatusBarHeight() {
        Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

}
