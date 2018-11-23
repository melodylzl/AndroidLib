package com.byvoid.lib.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.util.List;

/**
 * @author melody
 * @date 2018/6/15
 */
public class AppUtils {


    /**
     * 安装 apk 文件
     * @param context 上下文
     * @param apkFile 安装包
     */
    public static void installApk(Context context, File apkFile) {
        Intent installApkIntent = new Intent();
        installApkIntent.setAction(Intent.ACTION_VIEW);
        installApkIntent.addCategory(Intent.CATEGORY_DEFAULT);
        installApkIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        String appPackageName = getAppPackageName(context);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            installApkIntent.setDataAndType(FileProvider.getUriForFile(context, appPackageName + ".android7.fileProvider", apkFile), "application/vnd.android.package-archive");
            installApkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            installApkIntent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }

        if (context.getPackageManager().queryIntentActivities(installApkIntent, 0).size() > 0) {
            context.startActivity(installApkIntent);
        }
    }


    /**
     * 获取当前应用包名
     * @param context 上下文
     * @return 当前应用包名
     */
    public static String getAppPackageName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null){
            List<ActivityManager.RunningAppProcessInfo> processInfoList = activityManager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : processInfoList) {
                if (processInfo.pid == pid){
                    return processInfo.processName;
                }
            }
        }
        return "";
    }




}
