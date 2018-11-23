package com.byvoid.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @author melody
 * @date 2018/11/23
 */
public class FileProviderUtils {

    public static Uri getUriFromFile(Context context,File file){
        Uri fileUri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            fileUri = getUriFromFile24(context,file);
        }else{
            fileUri = Uri.fromFile(file);
        }
        return fileUri;
    }

    public static Uri getUriFromFile24(Context context,File file){
        String authority = context.getPackageName() + ".android7.FileProvider";
        return FileProvider.getUriForFile(context,authority,file);
    }

    public static void setIntentDataAndType(Context context,Intent intent,String type,File file,
                                            boolean isWriteAble){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            intent.setDataAndType(getUriFromFile24(context,file),type);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if (isWriteAble){
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        }else{
            intent.setDataAndType(Uri.fromFile(file),type);
        }
    }

}
