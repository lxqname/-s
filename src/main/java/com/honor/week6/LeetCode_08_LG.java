package com.honor.week6;

/**
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week6
 * @Description:
 * @date: 2019/7/12 16:16
 */
public class LeetCode_08_LG {
    
    public static void main(String[] args){  
        String st = " -42";
        System.out.println(myAtoi(st));
        String st1 = "    +11191657170";
        System.out.println(myAtoi(st1));
        String st3 = "+-2";
        System.out.println(myAtoi(st3));
        String st4 = "+2 3";
        System.out.println(myAtoi(st4));

        String st5 = "   +0 123";
        System.out.println(myAtoi(st5));

        String st6 = "- 234";
        System.out.println(myAtoi(st6));
        String st7 = "0-1";
        System.out.println(myAtoi(st7));
    }

    /**
     * 执行用时 :
     * 29 ms
     * , 在所有 Java 提交中击败了
     * 9.51%
     * 的用户
     * 内存消耗 :
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 70.73%
     * 的用户
     * 穷举，排除所有错误的内容答案
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        int result = 0;
        StringBuffer sb = new StringBuffer();
        String s = str;
        int tag = 0;
        int tagNum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            boolean numArea = c >= '0' && c <='9';
            if (" ".equals(String.valueOf(c)) || c=='+' || numArea || c=='-'){
                if ((c=='+' || c=='-') && (tag >= 1 || tagNum >=1)){
                    break;
                }
                if (' ' == c && tagNum >=1){
                    break;
                }
                if (tag >= 1){
                    if (numArea){
                        sb.append(c);
                        tagNum = 1;
                    }else {
                        break;
                    }
                }else {
                    if (c=='-' || numArea || c=='+'){
                        sb.append(c);
                        if (c=='-' || c=='+'){
                            tag = 1;
                        }
                        if (numArea){
                            tagNum = 1;
                        }
                    }
                }
            }else {
                break;
            }
        }

        if (sb.length() >= 1){
            try {
                result = Integer.parseInt(sb.toString().replace("+",""));
            } catch (NumberFormatException e) {
                if (sb.substring(0,1).equals("-")){
                    if (sb.length() == 1){
                        return 0;
                    }
                    return Integer.MIN_VALUE;
                }else if (sb.substring(0,1).equals("+")){
                    if (sb.length() == 1){
                        return 0;
                    }
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return result;
    }
}
