package com.honor.liuxinquan.day1031;

//java中调用start（）方法和run（）的区别

/**
 * 1.调用start()方法时，让开启的线程去执行run()方法，无须等待run()方法执行完，可继续执行下面方法
 * 2.调用run()，线程未开启，还是主线程去执行，需等待run()方法执行完，才可
 * 3.start()方法表示就绪状态，通过cpu时间片后，执行run()
 */
public class Test1 {
}
