package com.honor.week3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author 傅国俊
 */
public class LeetCode_03_FGJ {

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        String str4 = " ";
        System.out.println(getLengthFromLongestSubstring(str1) == 3);
        System.out.println(getLengthFromLongestSubstring(str2) == 1);
        System.out.println(getLengthFromLongestSubstring(str3) == 3);
        System.out.println(getLengthFromLongestSubstring(str4) == 1);
    }

    /**
     * 获得最长子串长度
     * 执行用时 : 27 ms , 在所有 Java 提交中击败了 72.56% 的用户
     * 内存消耗 : 39 MB , 在所有 Java 提交中击败了 84.18% 的用户
     *
     * @param s 字符串
     * @return int 最长子串长度
     */
    public static int getLengthFromLongestSubstring(String s) {
        int response = 0;
        if (null == s || s.isEmpty()) {
            return response;
        }
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>(s.length());
        do {
            if (set.contains(s.charAt(right))) {
                while (left < right) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        break;
                    } else {
                        set.remove(s.charAt(left));
                        left++;
                    }
                }
            } else {
                set.add(s.charAt(right));
            }
            right++;
            if (right - left > response) {
                response = right - left;
            }
        } while (right < s.length());
        return response;
    }

    /**
     * 获得最长子串长度-官方题解（有趣之处在于使用一个整数数组作为直接访问表-int [128] 用于ASCII码)
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 93.80% 的用户
     * 内存消耗 : 37.9 MB , 在所有 Java 提交中击败了 90.54% 的用户
     *
     * @param s 字符串
     * @return int 最长子串长度
     */
    public static int getLengthFromLongestSubstringFromOfficialSolution(String s) {
        int response = 0;
        int n = s.length();
        int[] index = new int[128];
        for (int right = 0, left = 0; right < n; right++) {
            left = Math.max(index[s.charAt(right)], left);
            response = Math.max(response, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }
        return response;
    }


}
