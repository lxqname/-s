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
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week20
 * @Description:
 * @date: 2019/10/26 10:16
 */
public class LeetCode_22_LG {

    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 99.47%
     * 的用户
     * 内存消耗 :
     * 36.3 MB
     * , 在所有 java 提交中击败了
     * 99.00%
     * 的用户
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int left = 0,right = 0;
        addBrackets(list,"",left,right,n);
        return list;
    }

    private static void addBrackets(List<String> list, String bracket,
                                    int left, int right, int n) {
        if (left == right && left == n){
            list.add(bracket);
            return;
        }

        if (left<n){
            addBrackets(list,bracket+"(",left+1,right,n);
        }

        if (right < left){
            addBrackets(list,bracket+")",left,right+1,n);
        }


    }
}
