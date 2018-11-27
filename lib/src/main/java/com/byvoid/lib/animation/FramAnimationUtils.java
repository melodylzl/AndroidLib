package com.byvoid.lib.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import com.byvoid.lib.utils.ResourceUtils;

/**
 * 帧动画Utils
 * @author melody
 * @date 2018/11/27
 */
public class FramAnimationUtils {

    /**
     * 获取帧动画AnimationDrawable
     * @param drawableNamePrefix 存放在drawable目录下的资源名称前缀，假设是voice_1,voice_2,voice_3....,前缀为voice_
     * @param startIndex 开始的资源索引，如上述例子是从1开始
     * @param endIndex 结束的资源索引
     * @param duration 每帧的持续时间(ms)
     * @return AnimationDrawable
     */
    public static AnimationDrawable getAnimationDrawable(String drawableNamePrefix,int startIndex,int endIndex,int duration){
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = startIndex ; i <= endIndex; ++i){
            String name = drawableNamePrefix + i;
            Drawable drawable = ResourceUtils.getDrawable(name);
            animationDrawable.addFrame(drawable,duration);
        }
        return animationDrawable;
    }

}
