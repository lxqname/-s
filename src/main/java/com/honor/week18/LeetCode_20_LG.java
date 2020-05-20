package com.honor.week18;

import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week18
 * @Description:
 * @date: 2019/10/13 11:03
 */
public class LeetCode_20_LG {

    public static void main(String[] args){  
        String str1 = "(]";
        System.out.println(isValid(str1));
    }

    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 java 提交中击败了
     * 77.93%
     * 的用户
     * 内存消耗 :
     * 34.5 MB
     * , 在所有 java 提交中击败了
     * 83.88%
     * 的用
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stringStack = new Stack<>();
        boolean valid = true;
        if (s == null || s.length() == 0){
            return valid;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (stringStack.empty()){
                stringStack.push(chars[i]);
                continue;
            }
            char peekStr = stringStack.peek();
            if (!isSame(peekStr,chars[i])){
                stringStack.push(chars[i]);
            }else {
                stringStack.pop();
            }
        }
        valid = stringStack.empty();
        return valid;
    }

    private static boolean isSame(char left, char right) {
        if (left == '(' && right == ')'){
            return true;
        }
        if (left == '{' && right == '}'){
            return true;
        }
        if (left == '[' && right == ']'){
            return true;
        }
        return false;
    }
}
