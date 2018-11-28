package com.byvoid.lib.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.byvoid.lib.AndroidLib;

/**
 * @author melody
 * @date 2018/11/28
 */
public class BitmapUtils {

    /**
     * Drawable转化为Bitmap
     * @param drawable drawable
     * @return bitmap
     */
    public static Bitmap drawableToBitmap(Drawable drawable){
        if (null == drawable){
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE
                        ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Bitmap转化为Drawable
     * @param bitmap bitmap
     * @return drawable
     */
    public static Drawable bitmapToDrawable(Bitmap bitmap){
        if (null == bitmap){
            return null;
        }
        return new BitmapDrawable(AndroidLib.getApplication().getResources(),bitmap);
    }

}
