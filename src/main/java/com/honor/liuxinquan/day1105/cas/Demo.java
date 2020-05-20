package com.honor.liuxinquan.day1105.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic提供了3个类用于原子更新基本类型：
 *          分别是AtomicInteger原子更新整形，AtomicLong原子更新长整形，AtomicBoolean原子更新bool值
 */
public class Demo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }

    /**
     *  getAndIncrement调用了unsafe的getAndAddInt，getAndAddInt的实现
     * @return
     */
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }

    /**
     * getAndAddInt调用了Unsafe的native方法：
     * getIntVolatile和compareAndSwapInt，
     * 在do-while循环中先取得当前值，然后通过CAS判断当前值是否和current一致，
     * 如果一致意味着值没被其他线程修改过，把当前值设置为当前值+var4，
     * 如果不相等程序进入信的CAS循环。
     * @param var1
     * @param var2
     * @param var4
     * @return
     */
    public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }
}
