package com.honor.liuxinquan.day1031;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 是一个接口,需要显式地获取和释放锁,不容易出现死锁状态
 * ReentrantLock 是 Lock 的实现类,称为排他锁或者互斥锁
 */
public class Test8 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new My2().start();
        }
    }
}

class My2 extends Thread {
    static int num = 1000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        sell();
    }

    private void sell() {
        while (true) {
            try {
                lock.lock();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num > 0) {
                    System.out.println(num--);
                } else {
                    System.out.println("完成");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
