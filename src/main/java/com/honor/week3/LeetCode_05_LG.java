package com.honor.week3;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week3
 * @Description:
 * @date: 2019/6/22 12:00
 */
public class LeetCode_05_LG {
    public static void main(String[] args){
        String s1= "bb";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome2(s1));
    }

    /**
     * 执行用时 :373 ms, 在所有 Java 提交中击败了10.91%的用户
     * 内存消耗 :235.8 MB, 在所有 Java 提交中击败了9.24%的用户
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int leng = ss.length;
        if(leng==1){
            return String.valueOf(ss[0]);
        }
        if(leng==0){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i<leng;i++){
            for(int j = i+1; j<leng;j++){
                if(ss[i] == ss[j] && j-i>end-start){
                    boolean flag =  isHuiWen(i, j, s);
                    if(flag){
                        start = i;
                        end = j;
                    }
                }
            }

        }
        if(start == end){
            return String.valueOf(ss[start]);
        }

        return s.substring(start,end+1);
    }

    public static boolean isHuiWen(int i,int j,String s){
        char[] ss = s.toCharArray();
        while(true){
            if(i == j || j - i == 1 ){
                if(ss[i] == ss[j]){
                    return true;
                }
                return false;
            }
            if(ss[i] == ss[j]){
                i++;
                j--;
            }else{
                return false;
            }

        }
    }


    /**
     * 执行用时 :14 ms, 在所有 Java 提交中击败了82.38%的用户
     * 内存消耗 :6.4 MB , 在所有 Java 提交中击败了90.99%的用户
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        char[] ss = s.toCharArray();
        int leng = ss.length;
        if(leng==1){
            return String.valueOf(ss[0]);
        }
        if(leng==0){
            return "";
        }
        int start = 0;
        int end = 0;
        int maxLeng = 0;
        for(int i = 1; i<leng;i++){
            int len1 = huiWenNumber(ss, i, i);
            int len2 = huiWenNumber(ss, i-1, i);
            if (len1 > maxLeng){
                start = i - len1/2;
                end = i + len1/2;
                maxLeng = len1;
            }

            if (len2 > maxLeng){
                start = i - len2/2;
                end = i - 1 + len2/2;
                maxLeng = len2;
            }

        }

        return s.substring(start,end+1);
    }

    private static int huiWenNumber(char[] ss, int l1, int l2) {
        int length = 1;

        while (l1 >= 0 && l2 < ss.length && ss[l1] == ss[l2]){
            length = l2-l1+1;
            l1--;
            l2++;
        }

        return length;
    }

}
