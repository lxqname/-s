package com.honor.week7;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week7
 * @Description:
 * @date: 2019/7/18 23:41
 */
public class LeetCode_09_LG {
    public static void main(String[] args){

    }

    /**
     * 执行用时 :
     * 53 ms
     * , 在所有 Java 提交中击败了
     * 42.90%
     * 的用户
     * 内存消耗 :
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 84.55%
     * 的用户
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if(s.length() <= 1){
            return true;
        }
        int end = s.length()-1;
        int start = 0;

        while(end > start){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
