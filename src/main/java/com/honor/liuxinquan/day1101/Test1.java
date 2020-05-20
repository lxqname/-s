package com.honor.liuxinquan.day1101;

import java.util.Scanner;

/**
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("输入一行字符");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        for (int i=0;i<s.length();i++){
            //判断是否是字母
            if (Character.isLetter(chars[i])){
                a++;
                //判断是否是数字
            }else if(Character.isDigit(chars[i])){
                b++;
            }else if (Character.isWhitespace(chars[i])){
                c++;
            }else {
                d++;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
