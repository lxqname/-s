package com.honor.week18;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/9/30 10:57
 */
public class LeetCode_20_LXQ {
    public static void main(String[] args) {
        String s = "{(})";
        if (null == s) {
            System.out.println(true);
        }
        if (s.length() % 2 != 0) {
            System.out.println(false);
        }
        boolean flag = true;
        int index = 0;
        char[] stack = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack[index++] = s.charAt(i);
                    continue;
                case ')':
                    if (index == 0 || stack[--index] != '(') {
                        flag = false;
                    }
                    continue;
                case ']':
                    if (index == 0 || stack[--index] != '[') {
                        flag = false;
                    }
                    continue;
                case '}':
                    if (index == 0 || stack[--index] != '{') {
                        flag = false;
                    }
                    continue;
            }
        }
        System.out.println(flag);
    }


}
