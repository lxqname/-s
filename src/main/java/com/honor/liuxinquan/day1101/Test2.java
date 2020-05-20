package com.honor.liuxinquan.day1101;

import java.util.Scanner;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，
 * 其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
 * 几个数相加有键盘控制。
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("请输入一个数");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("请输入几个数相加");
        Scanner scanner1 = new Scanner(System.in);
        int i1 = scanner1.nextInt();
        int sum=0;
        int count=i;
        for (int j=0;j<i1;j++){
            sum=sum+count;
            count=i+count*10;
        }
        System.out.println(sum);
    }
}
