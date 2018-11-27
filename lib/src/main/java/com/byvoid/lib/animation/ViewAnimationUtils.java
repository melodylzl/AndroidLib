package com.byvoid.lib.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * 常用View动画Utils
 * @author melody
 * @date 2018/11/26
 */
public class ViewAnimationUtils {

    public static TranslateAnimation translate(View targetView, float startX, float endX, float startY, float endY){
        return translate(targetView,startX,endX,startY,endY,300);
    }

    public static TranslateAnimation translate(View targetView, float startX, float endX, float startY, float endY, long duration){
        return translate(targetView,startX,endX,startY,endY,duration,null,false,null,true);
    }

    public static TranslateAnimation translate(View targetView, float startX, float endX, float startY, float endY,
                          long duration, Interpolator interpolator,boolean fillAfter, Animation.AnimationListener animationListener,boolean isStartAnim){
        TranslateAnimation translateAnimation = new TranslateAnimation(startX,endX, startY,endY);
        setAnimationConfig(translateAnimation,duration,interpolator,fillAfter,animationListener);
        if (targetView != null){
            targetView.setAnimation(translateAnimation);
        }
        if (isStartAnim){
            translateAnimation.start();
        }
        return translateAnimation;
    }

    public static RotateAnimation rotate(View targetView, float fromDegrees, float toDegrees, float pivotX, float pivotY){
        return rotate(targetView,fromDegrees,toDegrees,pivotX,pivotY,300);
    }

    public static RotateAnimation rotate(View targetView, float fromDegrees, float toDegrees, float pivotX, float pivotY, long duration){
        return rotate(targetView,fromDegrees,toDegrees,pivotX,pivotY,duration,null,false,null,true);
    }

    public static RotateAnimation rotate(View targetView, float fromDegrees, float toDegrees, float pivotX, float pivotY,
                          long duration, Interpolator interpolator,boolean fillAfter, Animation.AnimationListener animationListener,boolean isStartAnim){
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees,toDegrees,pivotX,pivotY);
        setAnimationConfig(rotateAnimation,duration,interpolator,fillAfter,animationListener);
        if (targetView != null){
            targetView.setAnimation(rotateAnimation);
        }
        if (isStartAnim){
            rotateAnimation.start();
        }
        return rotateAnimation;
    }

    public static ScaleAnimation scale(View targetView, float fromX, float toX, float fromY, float toY, float pivotX, float pivotY){
        return scale(targetView,fromX,toX,fromY,toY,pivotX,pivotY,300);
    }

    public static ScaleAnimation scale(View targetView, float fromX, float toX, float fromY, float toY, float pivotX, float pivotY, long duration){
        return scale(targetView,fromX,toX,fromY,toY,pivotX,pivotY,duration,null,false,null,true);
    }

    public static ScaleAnimation scale(View targetView, float fromX, float toX, float fromY, float toY, float pivotX, float pivotY,
                       long duration, Interpolator interpolator,boolean fillAfter, Animation.AnimationListener animationListener,boolean isStartAnim){
        ScaleAnimation scaleAnimation = new ScaleAnimation(fromX,toX,fromY,toY,pivotX,pivotY);
        setAnimationConfig(scaleAnimation,duration,interpolator,fillAfter,animationListener);
        if (targetView != null){
            targetView.setAnimation(scaleAnimation);
        }
        if (isStartAnim){
            scaleAnimation.start();
        }
        return scaleAnimation;
    }

    public static AlphaAnimation alpha(View targetView, float fromAlpha, float toAlpha){
        return alpha(targetView,fromAlpha,toAlpha,300);
    }

    public static AlphaAnimation alpha(View targetView, float fromAlpha, float toAlpha, long duration){
        return alpha(targetView,fromAlpha,toAlpha,duration,null,false,null,true);
    }

    public static AlphaAnimation alpha(View targetView, float fromAlpha, float toAlpha, long duration,
                      Interpolator interpolator,boolean fillAfter, Animation.AnimationListener animationListener,boolean isStartAnim){
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha,toAlpha);
        setAnimationConfig(alphaAnimation,duration,interpolator,fillAfter,animationListener);
        if (targetView != null){
            targetView.setAnimation(alphaAnimation);
        }
        if (isStartAnim){
            alphaAnimation.start();
        }
        return alphaAnimation;
    }

    public static AnimationSet playAnimationList(View targetView,long duration,boolean isStartAnim,Animation... animations){
        AnimationSet animationSet = new AnimationSet(false);
        for (Animation animation : animations){
            animationSet.addAnimation(animation);
        }
        animationSet.setDuration(duration);
        if (targetView != null){
            targetView.setAnimation(animationSet);
        }
        if (isStartAnim){
            animationSet.start();
        }
        return animationSet;
    }

    private static void setAnimationConfig(Animation animation, long duration, Interpolator interpolator,boolean fillAfter, Animation.AnimationListener animationListener){
        animation.setDuration(duration);
        if (interpolator != null){
            animation.setInterpolator(interpolator);
        }
        animation.setFillAfter(fillAfter);
        animation.setAnimationListener(animationListener);
    }
}
