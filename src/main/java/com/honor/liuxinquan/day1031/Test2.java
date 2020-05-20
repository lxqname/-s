package com.honor.liuxinquan.day1031;

/**
 * 多线程简单售票示例
 */
public class Test2 {
    public static void main(String[] args) {
        My1 my1 = new My1();
        for (int i = 0; i < 10; i++) {
            new Thread(my1, "窗口" + i).start();
        }
    }
}

class My1 implements Runnable {
    static int num = 1000;
    static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            flag = sell();
        }
    }

    private static synchronized boolean sell() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖第" + num-- + "票");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + "已卖完");
            return false;
        }
    }
}