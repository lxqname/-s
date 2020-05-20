package com.honor.liuxinquan.day1031;

import java.util.Map;

/**
 * 自定义String处理工具类
 */
public class SringUtils {
    /**
     * 首字母变小写
     *
     * @return
     */
    public static String firstChartolowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] chars = str.toCharArray();
            chars[0] += ('a' - 'A');
            return new String(chars);
        }
        return str;
    }

    /**
     * 将字符串中特定的字符转换为map中对应的值
     *
     * @param s
     * @param map
     * @return
     */
    public static String replace(String s, Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder((int) (s.length() * 1.5));
        int count = 0;
        for (int start, end; (start = s.indexOf("${", count)) != -1 && (end = s.indexOf("}", start)) != -1; ) {
            stringBuilder.append(s.substring(count, start)).append(map.get(s.substring(start + 2, end)));
            count = end + 1;
        }
        stringBuilder.append(s.substring(count, s.length()));
        return stringBuilder.toString();
    }


}
