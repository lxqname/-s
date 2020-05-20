package com.honor.liuxinquan.day1031;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 几种常见类型的线程池
 */
public class Test7 {
    public static void main(String[] args) {
        //1.newSingleThreadExecutor:
        // 创建一个单线程化的线程池，
        // 只会用唯一的工作线程执行任务
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
        //2.newFixedThreadPool:
        // 定长的线程池，有核心线程，
        // 核心线程的即为最大的线程数量，
        // 没有非核心线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //3.newCachedThreadPool:
        // 创建一个可缓存线程池，
        // 如果线程池长度超过处理需要，
        // 可灵活回收空余线程
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        //4.ScheduledExecutorService
        // 周期性执行任务的线程池，
        // 按照某种特定的计划执行线程中的任务，有核心线程，
        // 但也有非核心线程，非核心线程的大小也为无限大。
        // 适用于执行周期性的任务
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }

}

class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
