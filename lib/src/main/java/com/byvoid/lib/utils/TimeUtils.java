package com.byvoid.lib.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * 时间工具类
 * @author melody
 * @date 2018/11/1
 */
public class TimeUtils {

    /**
     * 一秒包含的毫秒数
     */
    private final static long MILLIS_PER_SECOND = 1000;
    /**
     * 一分钟的毫秒数
     */
    private final static long MILLIS_PER_MINUTE = MILLIS_PER_SECOND * 60;
    /**
     * 一小时的毫秒数
     */
    private final static long MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60;
    /**
     * 一天包含的毫秒数
     */
    private final static long MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;


    /**
     * 时间戳转化为字符串日期:yyyy-MM-dd
     * @param timeMillisecond 单位毫秒
     * @return 字符串日期
     */
    public static String stampToDate(long timeMillisecond) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return format.format(timeMillisecond);
    }

    /**
     * 时间戳转化为字符串日期:yyyy-MM-dd HH:mm:ss
     * @param timeMillisecond 单位毫秒
     * @return 字符串日期
     */
    public static String stampToFullDate(long timeMillisecond) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(timeMillisecond);
    }

    /**
     * 时间戳转化为字符串日期:yyyy-MM-dd HH:mm
     * @param timeMillisecond 单位毫秒
     * @return 字符串日期
     */
    public static String stampToDateNoSeconds(long timeMillisecond) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(timeMillisecond);
    }

    /**
     * 时间戳转化为字符串日期:yyyy-MM-dd HH:mm
     * @param timeMillisecond 单位毫秒
     * @return 字符串日期
     */
    public static String stampToDateNoYear(long timeMillisecond) {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(timeMillisecond);
    }


    /**
     * 格式化时间：1分钟内显示为刚刚;1小时内显示为xx分钟前；12小时内显示为xx小时前；
     * 今天内显示为：hh:mm; 今年内显示为：mm-dd；不是今年显示为：yy-mm.
     * @param timeMillisecond 时间（毫秒）
     * @return 返回格式化后的时间
     */
    public static String getFormatTimeWithRule(long timeMillisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentData = calendar.get(Calendar.DATE);

        calendar.setTimeInMillis(timeMillisecond);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int data = calendar.get(Calendar.DATE);

        if (currentYear != year) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            return simpleDateFormat.format(timeMillisecond);
        } else {
            if (currentMonth == month) {
                long now = System.currentTimeMillis();
                long absTime = Math.max(0, now - timeMillisecond);

                if (absTime < MILLIS_PER_MINUTE) {
                    return "刚刚";
                } else if (absTime < MILLIS_PER_HOUR) {
                    return String.format(Locale.getDefault(), "%d分钟前", absTime / MILLIS_PER_MINUTE);
                } else if (absTime < MILLIS_PER_HOUR * 12) {
                    return absTime / MILLIS_PER_HOUR + "小时前";
                } else if(absTime < MILLIS_PER_DAY) {
                    if (currentData == data){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                        return simpleDateFormat.format(timeMillisecond);
                    }
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.getDefault());
            return simpleDateFormat.format(timeMillisecond);
        }
    }


    /**
     * 返回当天是星期几
     * @return 当前是星期几
     */
    public static String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }
}
