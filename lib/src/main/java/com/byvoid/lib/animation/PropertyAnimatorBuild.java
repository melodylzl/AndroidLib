package com.byvoid.lib.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;

/**
 * 属性动画构造器
 * @author melody
 * @date 2018/11/27
 */
public class PropertyAnimatorBuild {

    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String ROTATION = "rotation";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String ALPHA = "alpha";

    private ValueAnimator mValueAnimator;

    public PropertyAnimatorBuild(ValueAnimator valueAnimator){
        mValueAnimator = valueAnimator;
    }

    public PropertyAnimatorBuild setTarget(Object target){
        mValueAnimator.setTarget(target);
        return this;
    }

    public PropertyAnimatorBuild setIntValues(int... values){
        mValueAnimator.setIntValues(values);
        return this;
    }

    public PropertyAnimatorBuild setFloatValues(float... values){
        mValueAnimator.setFloatValues(values);
        return this;
    }

    public PropertyAnimatorBuild setDuration(long duration){
        mValueAnimator.setDuration(duration);
        return this;
    }

    public PropertyAnimatorBuild setEvaluator(TypeEvaluator typeEvaluator){
        mValueAnimator.setEvaluator(typeEvaluator);
        return this;
    }

    public PropertyAnimatorBuild setRepeatCount(int repeatCount){
        mValueAnimator.setRepeatCount(repeatCount);
        return this;
    }

    public PropertyAnimatorBuild setRepeatMode(int repeatMode){
        mValueAnimator.setRepeatMode(repeatMode);
        return this;
    }

    public PropertyAnimatorBuild setStartDelay(long startDelay){
        mValueAnimator.setStartDelay(startDelay);
        return this;
    }

    public void start(){
        mValueAnimator.start();
    }

}
