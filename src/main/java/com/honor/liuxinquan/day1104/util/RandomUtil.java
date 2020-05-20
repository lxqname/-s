package com.honor.liuxinquan.day1104.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 * @author 86151
 */
public final class RandomUtil {

    public RandomUtil() {
    }

    public static int getRandomNum(int minNumber,int maxNumber){
        if (minNumber<0||maxNumber<0||minNumber>maxNumber){
            throw new IllegalArgumentException("minNumber 或者 maxNumber 范围不合法");
        }
        // 确保生成随机数的值在 minNumber 和 maxNumber 之间,
        // 这里最后加 1 是为了保证随机值可以等于最大值
        return ThreadLocalRandom.current().nextInt(minNumber, maxNumber+1);
    }
}
