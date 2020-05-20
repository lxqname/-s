package com.honor.liuxinquan.day1105;

/**
 * 题目：一个整数，它加上100后是一个完全平方数，
 * 再加上168又是一个完全平方数，请问该数是多少？
 */
public class Test2 {
    public static void main(String[] args) {
        for(int i=-100;i<10000;i++) {
            if(Math.sqrt(i+100)%1==0&&Math.sqrt(i+268)%1==0) {
                System.out.println(i);
            }
        }
    }
}
