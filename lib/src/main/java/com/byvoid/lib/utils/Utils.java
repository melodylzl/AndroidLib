package com.byvoid.lib.utils;

import java.util.concurrent.ThreadFactory;

/**
 * @author melody
 * @date 2018/11/28
 */
public class Utils {


    /**
     * 自定义线程工厂
     * @param name 自定义线程的名字
     * @param daemon 是否后台线程
     * @return ThreadFactory
     */
    public static ThreadFactory threadFactory(final String name, final boolean daemon) {
        return new ThreadFactory() {
            @Override public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName(name + thread.getId());
                thread.setDaemon(daemon);
                return thread;
            }
        };
    }
}
