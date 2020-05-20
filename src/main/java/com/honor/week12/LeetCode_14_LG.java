package com.honor.week12;

/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week11
 * @Description:
 * @date: 2019/8/20 18:36
 */
public class LeetCode_14_LG {
    
    public static void main(String[] args){
        String[] s = {"qwersdazcxzc","qwdazcxzc"};
        System.out.println("LuoGuang:LeetCode_14_LG.main():"+longestCommonPrefix(s));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.91%
     * 的用户
     * 内存消耗 :
     * 37.2 MB
     * , 在所有 Java 提交中击败了
     * 80.38%
     * 的用户
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        int minNum = strs.length;
        if (minNum == 0){
            return "";
        }
        String minStr = strs[0];
        for (String s : strs){
            if(minStr.length() >= s.length()){
                minStr = s;
            }
        }

        while (minStr.length() != 0){
            boolean flag = true;
            for (String s : strs){
                int index = s.indexOf(minStr);
                if (index != 0){
                    minStr = minStr.substring(0,minStr.length()-1);
                    flag = false;
                    break;
                }
            }
            if (flag){
                return minStr;
            }

        }
        return "";
    }
}