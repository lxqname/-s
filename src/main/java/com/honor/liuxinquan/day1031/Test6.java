package com.honor.liuxinquan.day1031;

import java.util.Scanner;

/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println("请输入第一个数：");
        Scanner scanner1 = new Scanner(System.in);
        int a = scanner1.nextInt();
        System.out.println("请输入第二个数：");
        Scanner scanner2 = new Scanner(System.in);
        int b = scanner2.nextInt();
        int i = getGYS(a, b);
        System.out.println("公约数为" + i);
        System.out.println("公倍数为" + a * b / i);
    }

    private static int getGYS(int a, int b) {
        if (a < b) {
            int t = b;
            b = a;
            a = t;
        }
        while (b != 0) {
            if (a == b) {
                return a;
            }
            int x = b;
            b = a % b;
            a = x;
        }
        return a;
    }
}
