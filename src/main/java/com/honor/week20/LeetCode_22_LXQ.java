package com.honor.week20;

import java.util.ArrayList;
import java.util.List;
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 执行用时 :
 * 1 ms, 在所有 java 提交中击败了99.45%的用户
 * 内存消耗 :
 * 36.2 MB, 在所有 java 提交中击败了99.00%的用户
 *
 */
public class LeetCode_22_LXQ {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n=3;
        add(list,"",0,0,n);
        System.out.println(list);;
    }

    private static void add(List<String> list, String s, int count1, int count2, int n) {
        if (count1<n&&count1>count2){
            add(list,s+"(",count1+1,count2,n);
            add(list,s+")",count1,count2+1,n);
        }else if (count1<n&&count1==count2){
            add(list,s+"(",count1+1,count2,n);
        }else if (count1==n){
           for (int i=0;i<n-count2;i++){
               s+=")";
           }
            list.add(s);
        }
    }
}
