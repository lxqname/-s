package com.honor.liuxinquan.day1101;

import java.util.Collection;
import java.util.regex.Pattern;

/**
 * 自定义工具类
 */
public class TestMyUtil {
    /**
     * 判断字符串是否为空，这里为空的标准为字符串等于null
     * 或者去除开头结尾的空值字符长度为0
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 判断collection集合和其子类是否为空，在这里都可以用这个方法
     * 判断标准为集合为null或者集合中没有元素
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() < 1;
    }

    /**
     * 通过正则表达式判断该字符串是否为邮箱格式
     * @param s
     * @return
     */
    public static boolean isEmail(String s){
        if (s==null){
            return false;
        }
        return Pattern.matches("^\\\\w+([-+.]\\\\w+)*@\\\\w+([-.]\\\\w+)*\\\\.\\\\w+([-.]\\\\w+)*$",s);
    }
}
