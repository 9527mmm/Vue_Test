package com.zxk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: JDBC_ONE
 * @description: date日期与string字符串转型工具类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-08 15:01
 **/
public class DateUtils {

    private DateUtils() {
    }

    private static final String DEFFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * date类型转string类型
     *
     * @param date
     * @param pattern
     * @return string
     */
    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    public static String date2Str(Date date) {
        return date2Str(date, DEFFAULT_PATTERN);
    }

    /**
     * string转date日期类型
     * @param str
     * @param pattern
     * @return date日期
     */
    public static Date str2Date(String str, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date str2Date(String str) {
        return str2Date(str, DEFFAULT_PATTERN);
    }
}
