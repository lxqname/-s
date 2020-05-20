package com.honor.liuxinquan.day1030;
//1. 有一串字符串String s = "ababab",
// 这个字符串可以看做由3个"ab"构成,即n=3, L = "ab", s = nL.
// 现在要求编写一段程序,使用单例模式,输入任意字符串s,输出nL.
// 如输入: aaaaa 输出 5a ,输入: ababa 输出: 1ababa

public class Test1 {

    public static void main(String[] args) {
        String s="ababab";
        UtilTest1 utilTest1 = UtilTest1.getUtilTest1();
        String result = utilTest1.getResult(s);
        System.out.println(result);
    }


}
