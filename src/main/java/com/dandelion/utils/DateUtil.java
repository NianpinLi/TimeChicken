package com.dandelion.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @ClassName: DateUtil
 * @date:      2019/9/29 14:50
 * @author:    puyiliang
 * @description:时间操作工具类
 */
public class DateUtil {

    /** 时间元素 */
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String WEEK = "week";
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";

     /** 星期元素 */
    private static final String MONDAY = "MONDAY";
    private static final String TUESDAY = "TUESDAY";
    private static final String WEDNESDAY = "WEDNESDAY";
    private static final String THURSDAY = "THURSDAY";
    private static final String FRIDAY = "FRIDAY";
    private static final String SATURDAY = "SATURDAY";
    private static final String SUNDAY = "SUNDAY";

    /** yyyy-MM-dd */
    private static final DateTimeFormatter YEAR_MONTH_DAY_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /** yyyy-MM-dd HH */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    /** yyyy-MM-dd HH:mm */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    /** yyyy-MM-dd HH:mm:ss */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /** HH:mm:ss */
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_EN = DateTimeFormatter.ofPattern("HH:mm:ss");
    /** yyyy年MM月dd日 */
    private static final DateTimeFormatter YEAR_MONTH_DAY_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    /** yyyy年MM月dd日HH时 */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时");
    /** yyyy年MM月dd日HH时mm分 */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分");
    /** yyyy年MM月dd日HH时mm分ss秒 */
    private static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
    /** HH时mm分ss秒 */
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_CN = DateTimeFormatter.ofPattern("HH时mm分ss秒");

    /** 本地时间显示格式：区分中文和外文显示 */
    private static final DateTimeFormatter SHORT_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    /** 本地时间显示格式：区分中文和外文显示 */
    private static final DateTimeFormatter FULL_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    /** 本地时间显示格式：区分中文和外文显示 */
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    /** 本地时间显示格式：区分中文和外文显示 */
    private static final DateTimeFormatter MEDIUM_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);


    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd
     * @author zero 2019/03/30
     */
    public static String getNowDateEn() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * 获取当前日期
     *
     * @return 字符串yyyy-MM-dd HH:mm:ss
     * @author zero 2019/03/30
     */
    public static String getNowTimeEn() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_EN);
    }

    /** 获取当前时间（yyyy-MM-dd HH） */
    public static String getNowTimeEnYearMonthDayHour() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_EN);
    }

    /** 获取当前时间（yyyy年MM月dd日） */
    public static String getNowTimeCnYearMonthDayHour() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_CN);
    }

    /** 获取当前时间（yyyy-MM-dd HH:mm） */
    public static String getNowTimeEnYearMonthDayHourMinute() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_MINUTE_EN);
    }

    /** 获取当前时间（yyyy年MM月dd日HH时mm分） */
    public static String getNowTimeCnYearMonthDayHourMinute() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_MINUTE_CN);
    }

    /** 获取当前时间（HH时mm分ss秒） */
    public static String getNowTimeCnHourMinuteSecond() {
        return LocalDateTime.now().format(HOUR_MINUTE_SECOND_CN);
    }

    /**
     * 根据日期格式，获取当前时间
     *
     * @param formatStr 日期格式<br>
     *        <li>yyyy</li>
     *        <li>yyyy-MM-dd</li>
     *        <li>yyyy-MM-dd HH:mm:ss</li>
     *        <li>HH:mm:ss</li>
     * @return String
     */
    public static String getTime(String formatStr) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 获取中文的当前日期
     * @return yyyy年mm月dd日
     */
    public static String getNowDateCn() {
        return LocalDate.now().format(YEAR_MONTH_DAY_CN);
    }

    /**
     * 获取中文当前时间
     * @return yyyy年MM月dd日HH时mm分ss秒
     */
    public static String getNowTimeCn() {
        return LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_CN);
    }

    /**
     * 简写本地当前日期：yy-M-dd<br>
     * 例如：19-3-30为2019年3月30日
     * @return 字符串yy-M-dd
     */
    public static String getNowLocalTimeShot() {
        return LocalDateTime.now().format(SHORT_DATE);
    }

    /**
     * 根据当地日期显示格式：yyyy年M月dd日 星期？（中国）
     * @return 形如：2019年3月30日 星期六
     */
    public static String getNowLocalTimeFull() {
        return LocalDateTime.now().format(FULL_DATE);
    }

    /**
     * 根据当地显示日期格式：yyyy年M月dd日（中国）
     * @return 形如 2019年3月30日
     */
    public static String getNowLocalTimeLong() {
        return LocalDateTime.now().format(LONG_DATE);
    }

    /**
     * 根据当地显示日期格式：yyyy-M-dd（中国）
     * @return 形如：2019-3-30
     */
    public static String getNowLocalTimeMedium() {
        return LocalDateTime.now().format(MEDIUM_DATE);
    }

    /**
     * 获取当前日期的节点时间（年，月，周，日，时，分，秒）
     * @param node 日期中的节点元素（年，月，周，日，时，分，秒）
     * @return 节点数字，如创建此方法的时间：年 2019，月 3，日 30，周 6
     */
    public static Integer getNodeTime(String node) {
        LocalDateTime today = LocalDateTime.now();
        Integer resultNode;
        switch (node) {
            case YEAR:
                resultNode = today.getYear();
                break;
            case MONTH:
                resultNode = today.getMonthValue();
                break;
            case WEEK:
                resultNode = transformWeekEnToNum(String.valueOf(today.getDayOfWeek()));
                break;
            case DAY:
                resultNode = today.getDayOfMonth();
                break;
            case HOUR:
                resultNode = today.getHour();
                break;
            case MINUTE:
                resultNode = today.getMinute();
                break;
            case SECOND:
                resultNode = today.getSecond();
                break;
            default:
                // 当前日期是当前年的第几天。例如：2019/1/3是2019年的第三天
                resultNode = today.getDayOfYear();
                break;
        }
        return resultNode;
    }

    /**
     * 将英文星期转换成数字
     * @param enWeek 英文星期
     * @return int，如果数字小于0，则检查，看是否输入错误 or 入参为null
     */
    public static int transformWeekEnToNum(String enWeek) {
        if (MONDAY.equals(enWeek)) {
            return 1;
        } else if (TUESDAY.equals(enWeek)) {
            return 2;
        } else if (WEDNESDAY.equals(enWeek)) {
            return 3;
        } else if (THURSDAY.equals(enWeek)) {
            return 4;
        } else if (FRIDAY.equals(enWeek)) {
            return 5;
        } else if (SATURDAY.equals(enWeek)) {
            return 6;
        } else if (SUNDAY.equals(enWeek)) {
            return 7;
        } else {
            return -1;
        }
    }

}
