package com.honor.liuxinquan.day1030;
//题目：判断101-200之间有多少个素数，并输出所有素数。
public class Test3 {
    public static void main(String[] args) {
        int count=0;
        for (int i=101;i<=200;i++){
            boolean flag=true;
            for (int j=2;j<Math.sqrt(i);j++){
                if (i%j==0){
                    flag=false;
                    break;
                }
            }
            if (flag){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
