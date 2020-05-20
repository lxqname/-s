package com.honor.week4;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * @author 傅国俊
 */
public class LeetCode_05_FGJ {

    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println(LeetCode_05_FGJ.longestPalindrome(s1));
        String s2 = "cbbd";
        System.out.println(LeetCode_05_FGJ.longestPalindrome(s2));
    }

    /**
     * 获取最长回文子串
     * 执行用时 : 333 ms , 在所有 Java 提交中击败了 11.05% 的用户
     * 内存消耗 : 287.8 MB , 在所有 Java 提交中击败了 8.88% 的用户
     *
     * @param s 字符串
     * @return String 最长回文
     */
    public static String longestPalindrome(String s) {
        String response = "";
        if (null == s || s.length() == 0) {
            return response;
        }
        char[] charArray = s.toCharArray();
        int left = (charArray.length - 1) / 2;
        int right = charArray.length / 2;
        if (left != right) {
            if (charArray[left] == charArray[right]) {
                String palindrome = LeetCode_05_FGJ.getPalindrome("" + charArray[left] + charArray[right], charArray, left - 1, right + 1);
                if (palindrome.length() > response.length()) {
                    response = palindrome;
                }
            }
        }
        while ((left > 0 && left * 2 + 1 > response.length()) || (right < charArray.length && (charArray.length - right - 1) * 2 + 1 > response.length())) {
            if (left * 2 + 1 > response.length()) {
                String palindrome = LeetCode_05_FGJ.getPalindrome(String.valueOf(charArray[left]), charArray, left - 1, left + 1);
                if (palindrome.length() > response.length()) {
                    response = palindrome;
                }
                int leftLeft = left - 1;
                if (leftLeft >= 0 && charArray[leftLeft] == charArray[left]) {
                    palindrome = LeetCode_05_FGJ.getPalindrome("" + charArray[leftLeft] + charArray[left], charArray, leftLeft - 1, left + 1);
                    if (palindrome.length() > response.length()) {
                        response = palindrome;
                    }
                }
                left = left - 1;
            }
            if ((charArray.length - right - 1) * 2 + 1 > response.length()) {
                String palindrome = LeetCode_05_FGJ.getPalindrome(String.valueOf(charArray[right]), charArray, right - 1, right + 1);
                if (palindrome.length() > response.length()) {
                    response = palindrome;
                }
                int rightRight = right + 1;
                if (rightRight < charArray.length && charArray[right] == charArray[rightRight]) {
                    palindrome = LeetCode_05_FGJ.getPalindrome("" + charArray[right] + charArray[rightRight], charArray, right - 1, rightRight + 1);
                    if (palindrome.length() > response.length()) {
                        response = palindrome;
                    }
                }
                right = right + 1;
            }
        }
        return response;
    }

    /**
     * 获取回文
     *
     * @param palindrome 当前回文
     * @param charArray  字符数组
     * @param left       左坐标
     * @param right      右坐标
     * @return String 回文
     */
    public static String getPalindrome(String palindrome, char[] charArray, int left, int right) {
        if (left < 0 || right >= charArray.length) {
            return palindrome;
        }
        if (charArray[left] == charArray[right]) {
            palindrome = charArray[left] + palindrome + charArray[right];
            return LeetCode_05_FGJ.getPalindrome(palindrome, charArray, left - 1, right + 1);
        } else {
            return palindrome;
        }
    }

    /**
     * 获取最长回文子串-中心扩展算法
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 89.29% 的用户
     * 内存消耗 : 35.5 MB , 在所有 Java 提交中击败了 92.78% 的用户
     *
     * @param s 字符串
     * @return String 最长回文
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展
     *
     * @param s     字符串
     * @param left  左下标
     * @param right 右下标
     * @return int 长度
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
