package com.honor.liuxinquan.day1106;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtil {
    /*
     * datetime格式的时间支持所有的转化 但是date类型的显然是不能
     * */
    public static String dateToString(Date date, String patten) {
        return OldDateUtil.format(date, patten);
    }

    private static String YMD_NUMBER = "\\d{8}";
    private static String YMDH_NUMBER = "\\d{10}";
    private static String YMDHM_NUMBER = "\\d{12}";
    private static String YMDHMS_NUMBER = "\\d{14}";
    private static String YMD_STRING = "\\d{4}-\\d{1,2}-\\d{1,2}";
    private static String YMDHMS_STRING = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,3}.*";

    private static String temp = "-";

    public static Date stringToDate(String dateStr) {
        Pattern ymdNumber = Pattern.compile(YMD_NUMBER);
        Pattern ymdhNumber = Pattern.compile(YMDH_NUMBER);
        Pattern ymdhmNumber = Pattern.compile(YMDHM_NUMBER);
        Pattern ymdhmsNumber = Pattern.compile(YMDHMS_NUMBER);
        Pattern ymdTemp = Pattern.compile(YMD_STRING);
        Pattern ymdhmsTemp = Pattern.compile(YMDHMS_STRING);
        try {
            if (dateStr.contains(temp)) {
                //yyyy-MM-dd
                if (ymdTemp.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyy-MM-dd");
                }
                //  yyyy-MM-dd HH:mm:ss
                if (ymdhmsTemp.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss");
                }
            } else {
                //yyyyMMdd
                if (ymdNumber.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyyMMdd");
                }
                //yyyyMMddHH
                if (ymdhNumber.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyyMMddHH");
                }
                //yyyyMMddHHmm
                if (ymdhmNumber.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyyMMddHHmm");
                }
                //yyyyMMddHHmmss
                if (ymdhmsNumber.matcher(dateStr).matches()) {
                    return OldDateUtil.parse(dateStr, "yyyyMMddHHmmss");
                }
            }
        } catch (Exception e) {
            System.out.println("转化异常：" + dateStr);
        }
        return null;
    }

    private static int ten = 10;

    public static Date longToDate(String longtime) {
        if (longtime.length() > ten) {
            longtime = longtime.substring(0, 10);
        }
        Long timestamp = Long.valueOf(longtime);
        if (timestamp == 0) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        return c.getTime();
    }

    /**
     * 日期累加
     *
     * @param format 返回的日期格式
     * @param year   加多少年
     * @param month  加多少个月
     * @param day    加多少天
     * @return
     */
    public static String getSysDate(String format, Date date, int year,
                                    int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        return OldDateUtil.format(cal.getTime(), format);
    }


    /**
     * 日期累加
     *
     * @param format 返回的日期格式
     * @param hour   加多少小时
     * @param min    加多少分钟
     * @param second 加多少秒
     * @return
     */
    public static Long getDateLong(String format, String date, int hour,
                                   int min, int second) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.stringToDate(date));

        if (hour != 0) {
            cal.add(Calendar.HOUR, hour);
        }
        if (min != 0) {
            cal.add(Calendar.MINUTE, min);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime().getTime();
    }


    public static Date getDatePlus(Date date, int year,
                                   int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        return cal.getTime();
    }

    public static Date getDatePlus2(Date date, int hour,
                                    int min, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (hour != 0) {
            cal.add(Calendar.HOUR, hour);
        }
        if (min != 0) {
            cal.add(Calendar.MINUTE, min);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }

    public static Long dateToLong(Date time) {
        return time.getTime();
    }

    public static long stringToLong(String str) {
        long time = 0L;
        Date date = stringToDate(str);
        return date.getTime();
    }

    private static int tenFour = 14;
    private static int six = 6;

    public static String changeEnd(String end) {
        StringBuilder sb = new StringBuilder(end);
        String[] str = new String[]{"2", "3", "5", "9", "5", "9"};
        if (end.length() < tenFour) {
            int flag = tenFour - end.length();
            for (int i = six - flag; i < str.length; i++) {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }

    private static char m = 'm';
    private static char h = 'h';
    private static char d = 'd';

    /**
     * 比较两个时间的相差值（d1与d2）
     *
     * @param d1   时间一
     * @param d2
     * @param type 类型【d/h/m/s】
     * @return d1 - d2
     */
    public static long compareDate(Date d1, Date d2, char type) {
        long num = d1.getTime() - d2.getTime();
        num /= 1000;
        if (m == type) {
            num /= 60;
        } else if (h == type) {
            num /= 3600;
        } else if (d == type) {
            num /= 3600;
            num /= 24;
        }
        return num;
    }

//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(DateUtil.getDatePlus(new Date(), 0, -1, 0)));
//        //System.out.println(changeEnd("2017082722"));
//    }
}
