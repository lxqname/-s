package com.honor.week7;

/**
 * 8. 字符串转换整数 (atoi)
 * 实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：假设我们的环境只能存储 32 位大小的有符号整数。如果数值超过这个范围，请返回  INT_MAX  或 INT_MIN 。
 *
 * @author 蝈蝈
 * @since 2019年09月15日 15:10
 */
public class LeetCode_08_FGJ {

    public static void main(String[] args) {
        String str1 = "42";
        System.out.println(myAtoi(str1));
        String str2 = "-42";
        System.out.println(myAtoi(str2));
        String str3 = "4193 with words";
        System.out.println(myAtoi(str3));
        String str4 = "words and 987";
        System.out.println(myAtoi(str4));
        String str5 = "-91283472332";
        System.out.println(myAtoi(str5));
        System.out.println(myAtoi(null));
    }

    /**
     * 字符串转换整数
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 76.05% 的用户
     * 内存消耗 : 35.9 MB , 在所有 Java 提交中击败了 87.15% 的用户
     *
     * @param str 字符串
     * @return int 整数
     */
    private static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        // 是否已开始转换
        boolean begin = false;
        // 是否正整数
        boolean positiveInteger = true;
        int response = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                if (begin) {
                    break;
                }
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                if (begin) {
                    break;
                } else {
                    begin = true;
                    if (str.charAt(i) == '-') {
                        positiveInteger = false;
                    }
                }
            } else if (Character.isDigit(str.charAt(i))) {
                if (!begin) {
                    begin = true;
                }
                int pop = str.charAt(i) - '0';
                if (positiveInteger) {
                    if (response > Integer.MAX_VALUE / 10 || (response == Integer.MAX_VALUE / 10 && pop > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    response = response * 10 + pop;
                } else {
                    if (response < Integer.MIN_VALUE / 10 || (response == Integer.MIN_VALUE / 10 && pop > 8)) {
                        return Integer.MIN_VALUE;
                    }
                    response = response * 10 - pop;
                }
            } else {
                break;
            }
        }
        return response;
    }
}
