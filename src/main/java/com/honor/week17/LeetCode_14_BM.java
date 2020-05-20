package com.honor.week17;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 执行用时 :
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.11%
 * 的用户
 * 内存消耗 :
 * 37.6 MB
 * , 在所有 Java 提交中击败了
 * 73.99%
 * 的用户
 *
 * @Author: 白猛
 * @Date: 2019/9/29 19:21
 */
public class LeetCode_14_BM {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return strs.length == 0 ? "" : strs[0];
        }
        StringBuilder commonString = new StringBuilder();
        String s = "";

        A:
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                s = strs[j];
                if (s.length() - 1 < i || c != s.charAt(i)) {
                    break A;
                }
            }
            commonString.append(c);
        }
        return commonString.toString();
    }
}
