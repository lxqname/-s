package com.honor.liuxinquan.day1030;

/**
 *      通过设置开关变量来中断线程
 *          主线程和子线程同时打印0-999,当主线程打印到100,中断子线程
 */
public class Test4 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for (int i=0;i<1000;i++){
            if (i==100){
                myThread1.setFlag(true);
            }
            System.out.println(i);
        }
    }
}

class MyThread1 extends Thread{
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            if (flag){
                return;
            }
            System.out.println("子线程"+i);
        }
    }
}
