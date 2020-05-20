package com.honor.liuxinquan.day1030;
//古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
// 小兔子长到第三个月后每个月又生一对兔子，
// 假如兔子都不死，问每个月的兔子总数为多少？
public class Test2 {
    public static void main(String[] args) {
        int a=1,sum=1,b;
        for (int i=3;i<5;i++){
            b=sum;
            sum=a+sum;
            a=b;
            System.out.println(sum*2);
        }
    }
}
