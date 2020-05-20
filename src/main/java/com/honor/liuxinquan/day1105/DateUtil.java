package com.honor.liuxinquan.day1105;


import java.util.Calendar;
import java.util.Date;

/**
 * @Description 日期工具类
 * @Author lizhongbao
 * @Date 2019/7/30 15:54
 * @Version 1.0
 **/
public class DateUtil {

    /**
     * 获取当天最小时间
     * @param date
     * @return
     */
    public static Date geDayMinimum(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将时分秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 获取本周第一天
     * @param date
     * @return
     */
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        setTime(cal);
        return cal.getTime();
    }

    /**
     * 获取本月的第一天
     * @param date
     * @return
     */
    public static Date getMonthFirstDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);
        setTime(calendar);
        return calendar.getTime();
    }

    /**
     * 时分秒制为00：00：00:0000
     * @param calendar
     * @return
     */
    public static Calendar setTime(Calendar calendar){
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static void main(String[] args) {
        System.out.println(getMonthFirstDay(new Date()));
        System.out.println(getThisWeekMonday(new Date()));
    }

}
