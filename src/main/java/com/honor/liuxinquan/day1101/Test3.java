package com.honor.liuxinquan.day1101;

/**
 * 题目：一个数如果恰好等于它的因子之和，
 *      这个数就称为 "完数 "。例如6=1＋2＋3.编程
 *      找出1000以内的所有完数。
 */
public class Test3 {
    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            int sum=0;
            for (int j=1;j<=i/2;j++){
                if (i%j==0){
                    sum+=j;
                }
            }
            if (i==sum){
                System.out.println(sum);
            }
        }
    }
}
