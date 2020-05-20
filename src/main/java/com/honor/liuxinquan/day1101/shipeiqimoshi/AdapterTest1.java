package com.honor.liuxinquan.day1101.shipeiqimoshi;

/**
 * 适配器模式:有一个Source类，拥有一个方法，待适配，
 *           目标接口时Targetable，通过Adapter类，
 *           将Source的功能扩展到Targetable里
 */
public class AdapterTest1 extends Source implements Adapter {
    @Override
    public void method2() {
        System.out.println("test");
    }
}
