package com.honor.week5;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week5
 * @Description:
 * @date: 2019/7/3 11:29
 */
public class LeetCode_07_LG {

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
        System.out.println(reverse1(1534236469));
    }

    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了30.54%的用户
     * 内存消耗 :34.9 MB, 在所有 Java 提交中击败了77.66%的用户
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        String s = String.valueOf(x);
        if(x >= 0){
            for (int i = s.length()-1; i >= 0; i--){
                sb.append(s.charAt(i));
            }
            s = sb.toString();
        }else{
            for (int i = s.length()-1; i > 0; i--){
                sb.append(s.charAt(i));
            }
            s = "-"+sb.toString();
        }


        int result = 0;

        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return result;
        }
        return result;
    }

    /**
     * 执行用时 :9 ms, 在所有 Java 提交中击败了37.97%的用户内存消耗 :34.8 MB, 在所有 Java 提交中击败了77.76%的用户
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        int num = x;
        num = num>0?num:num*-1;

        int result = 0;
        int count = 0;
        while (num > 0 ){
            result = result*10 + num%10;
            if (result/10 + num%10 != (count + num%10)){
                return 0;
            }
            num = num/10;
            count = result;
        }
        try {
            result = Integer.parseInt(String.valueOf(result));
        } catch (NumberFormatException e) {
            return 0;
        }
        return x>0?result:result*-1;
    }
}
