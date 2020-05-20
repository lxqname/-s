package com.honor.liuxinquan.day1113;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author 86151
 */
public class LeetCode_28_LXQ {

    public int strStr(String haystack, String needle) {
        if (needle.length()==0||haystack.equals(needle)){
            return 0;
        }
        if (haystack.length()==0||haystack.length()<needle.length()){
            return -1;
        }
        int rs=-1;
        for (int i=0;i<haystack.length();i++){
            if (!needle.contains(haystack.substring(i,i+1))){
                i+=needle.length();
                continue;
            }
            if (i+needle.length()<=haystack.length()&&haystack.substring(i,i+needle.length()).equals(needle)){
                 rs=i;
                 break;
            }
        }
        return rs;
    }
}
