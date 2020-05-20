package com.honor.liuxinquan.day1101.shipeiqimoshi;

/**
 * 对象的适配器模式
 *    基本思路和类的适配器模式相同，
 *    只是将Adapter类作修改，
 *    这次不继承Source类，而是持有Source类的实例，
 *    以达到解决兼容性的问题
 */
public class AdapterTest2 implements Adapter {
    private Source source;

    public AdapterTest2(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        System.out.println(1);
    }

    @Override
    public void method2() {
        System.out.println(2);
    }
}
