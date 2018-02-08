package com.user.paopao.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author：lily
 * date：2017/12/28 13:48
 * description:  时间转化工具类
 */

public class TimeUtils {
    private static Calendar calendar = Calendar.getInstance();
    private static SimpleDateFormat ftime = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String getTimestamp() {
        return ftime.format(calendar.getTime()).toString();
    }

}
