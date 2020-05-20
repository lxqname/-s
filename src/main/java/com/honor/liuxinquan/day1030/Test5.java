package com.honor.liuxinquan.day1030;
//线程的加入(join)
//　　假设有一个线程A，现在需要插入线程B，
// 并要求线程B先执行完毕，然后再继续执行线程A，
// 此时可以使用join()方法来完成。
// 当某个线程使用join()方法加入到另一个线程时，
// 另一个线程会等待该线程执行完毕再继续执行。
public class Test5 {
    public static void main(String[] args) {
        My2 my2 = new My2();
        My1 my1 = new My1(my2);
        my1.start();
        my2.start();
    }
}

class My1 extends Thread{
    private Thread thread;
    public My1(Thread thread){
        this.thread=thread;
    }

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            if (i==10){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MY1"+i);
        }
    }
}

class My2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("MY2"+i);
        }
    }
}