package com.byvoid.lib.provider;

import android.support.v4.content.FileProvider;

/**
 * lib自定义FileProvider类
 * 防止主工程也在Manifest文件里定义相同的系统provider发生冲突
 * @author melody
 * @date 2018/11/23
 */
public class CustomFileProvider extends FileProvider {
}
