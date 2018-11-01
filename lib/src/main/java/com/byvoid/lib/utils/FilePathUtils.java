package com.byvoid.lib.utils;

import android.os.Environment;
import com.byvoid.lib.AndroidLib;
import java.io.File;

/**
 * 文件路径管理类
 * @author melody
 * @date 2018/3/28
 */
public class FilePathUtils {


    /**
     * 获取内存缓存目录的绝对路径
     * @return /data/data/<package_name>/cache
     */
    public static String getMemoryCachePath(){
        return AndroidLib.getApplication().getCacheDir().getPath();
    }

    /**
     * 获取内存文件目录的绝对路径
     * @return /data/data/<package_name>/files
     */
    public static String getMemoryFilesPath(){
        return AndroidLib.getApplication().getFilesDir().getPath();
    }

    /**
     * 获取外置SD卡缓存目录的绝对路径
     * 如果外置SD卡不存在或者不可用，则返回内存缓存目录
     * @return /Android/data/<package_name>/cache
     */
    public static String getExternalCachePath(){
        if (isExistSDCard()){
            File externalCacheFile = AndroidLib.getApplication().getExternalCacheDir();
            if (externalCacheFile != null){
                return externalCacheFile.getPath();
            }
        }
        return getMemoryCachePath();
    }

    /**
     * 获取外置SD卡文件目录的绝对路径
     * 如果外置SD卡不存在或者不可用，则返回内存文件目录
     * @return /Android/data/<package_name>/files
     */
    public static String getExternalFilesPath(){
        if (isExistSDCard()){
            File externalFiles = AndroidLib.getApplication().getExternalFilesDir(null);
            if (externalFiles != null){
                return externalFiles.getPath();
            }
        }
        return getMemoryFilesPath();
    }

    /**
     * 判断SD卡是否存在
     * @return true or false
     */
    private static boolean isExistSDCard(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
