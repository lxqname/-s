package com.honor.liuxinquan.day1104;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Test1 {
    public static void main(String[] args) {
        int height=100;
        int sum=100;
        for (int i=1;i<=10;i++){
            height=height/2;
            sum+=2*height;
        }
        System.out.println(sum);
        System.out.println(height);
    }
}
