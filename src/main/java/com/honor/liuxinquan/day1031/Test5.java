package com.honor.liuxinquan.day1031;

import java.util.Scanner;

/**
 * 题目：利用条件运算符的嵌套来完成此题：
 * 学习成绩> =90分的同学用A表示，
 * 60-89分之间的用B表示，
 * 60分以下的用C表示。
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println("请输入一个数");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        char a = (i >= 90 ? 'A' : (i >= 60 ? 'B' : 'C'));
        System.out.println(a);
    }
}
