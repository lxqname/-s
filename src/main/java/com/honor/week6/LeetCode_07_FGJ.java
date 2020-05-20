package com.honor.week6;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @author 蝈蝈
 * @since 2019年09月14日 14:29
 */
public class LeetCode_07_FGJ {

    public static void main(String[] args) {
        int num1 = 123;
        System.out.println(reverse(num1));
        int num2 = -123;
        System.out.println(reverse(num2));
        int num3 = 120;
        System.out.println(reverse(num3));
        int num4 = 1534236469;
        System.out.println(reverse(num4));
    }

    /**
     * 整数反转
     * 执行用时 :3 ms, 在所有 Java 提交中击败了92.53%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了79.24%的用户
     *
     * @param x 32位有符号整数
     * @return int 反转后的整数，整数溢出则返回0
     */
    private static int reverse(int x) {
        long response = 0;
        while (x != 0) {
            response = response * 10 + x % 10;
            x = x / 10;
        }
        if (response > Integer.MAX_VALUE || response < Integer.MIN_VALUE) {
            response = 0;
        }
        return (int) response;
    }

    /**
     * 整数反转-官方题解
     * 考虑过这种解法，但想到要使用额外的内存去保存临时变量，觉得效率会变低
     * 但这做法才是本题真正考察点，如果没有更大的存储范围类型，则我的做法是无法实现的
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了92.53%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了77.83%的用户
     *
     * @param x 32位有符号整数
     * @return int 反转后的整数，整数溢出则返回0
     */
    private static int reverseFromOfficialSolution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
