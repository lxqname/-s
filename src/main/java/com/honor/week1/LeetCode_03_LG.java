package com.honor.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week1
 * @Description: 无重复字符的最长子串
 * @date: 2019/6/3 21:20
 */
public class LeetCode_03_LG {
    public static void main(String[] args){
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = " ";
        String s6 = "dvdf";
        int count = lengthOfLongestSubstring(s6);
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int right = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){

            if (set.contains(s.charAt(right))){
                set.remove(s.charAt(left ++));
            }else {
                set.add(s.charAt(right ++));
                maxCount = (right-left) > maxCount?(right-left): maxCount;
            }
        }

        return maxCount;
    }

}
