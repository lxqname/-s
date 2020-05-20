package com.honor.liuxinquan.day1030;

import java.util.Random;
import java.util.Scanner;

public class ShuZiPingTu {
    public static void main(String[] args) {
        int[] a = new int[9];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int index = random.nextInt(9);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
        int[][] b = new int[3][3];
        int c = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = a[c++];
            }
        }
        for (int[] i : b) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("请输入W,A,S,D");
            switch (scanner.next()) {
                case "W":
                    test2(b, 0);
                    break;
                case "S":
                    test1(b, 2);
                    break;
                case "A":
                    test2(b, 0);
                    break;
                case "D":
                    test1(b, 2);
                    break;
            }
            for (int[] i : b) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            if (b[0][0] == 1 && b[0][1] == 2 && b[0][2] == 3 && b[1][0] == 4 && b[1][1] == 5 && b[1][2] == 6 && b[2][0] == 7 && b[2][1] == 8 && b[2][2] == 0) {
                flag = false;
                System.out.println("牛B，恭喜你通关了");
            }
        }
    }

    public static void test1(int[][] b, int c) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == 0 && j != c) {
                    int temp = b[i][j];
                    b[i][j] = b[i][j + 1];
                    b[i][j + 1] = temp;
                    break;
                }
            }
        }
    }

    public static void test2(int[][] b, int c){
        A: for (int i=0;i<b.length;i++){
            for (int j=0;j<b[i].length;j++){
                if (b[i][j]==0&&i!=0){
                    int temp=b[i][j];
                    b[i][j]=b[i-1][j];
                    b[i-1][j]=temp;
                    break  A;
                }
            }
        }
    }
}

