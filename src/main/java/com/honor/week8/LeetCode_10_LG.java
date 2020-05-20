package com.honor.week8;

/**
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week8
 * @Description:
 * @date: 2019/7/22 20:28
 */
public class LeetCode_10_LG {
    
    public static void main(String[] args){  
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s,p));
        String s1 = "aa";
        String p1 = "a*3";
        System.out.println(isMatch(s1,p1));
//        String s2 = "ab";
//        String p2 = ".*";
//        System.out.println(isMatch(s2,p2));
//        String s3 = "aab";
//        String p3 = "c*a*b";
//        System.out.println(isMatch(s3,p3));
//        String s4 = "mississippi";
//        String p4 = "mis*is*p*.";
//        System.out.println(isMatch(s4,p4));


    }

    /**
     * 执行用时 :
     * 147 ms
     * , 在所有 Java 提交中击败了
     * 32.88%
     * 的用户
     * 内存消耗 :
     * 83.5 MB
     * , 在所有 Java 提交中击败了
     * 8.49%
     * 的用户
     * 递归方法，未答出，根据答案调试
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }

        // 比较第一个字符是否相等
        boolean firstMatch =(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
        }else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }

    }
}
