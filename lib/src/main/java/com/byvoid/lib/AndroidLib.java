package com.byvoid.lib;

import android.app.Application;
import android.content.Context;

/**
 * @author melody
 * @date 2018/11/1
 */
public class AndroidLib {

    private static Application sApplication;

    public static void init(Context context){
        sApplication = (Application) context.getApplicationContext();
    }

    public static Application getApplication() {
        return sApplication;
    }

}
