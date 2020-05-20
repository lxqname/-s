package com.honor.liuxinquan.day1104.jdk;


import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * jdk动态代理 :针对实现了接口的类产生代理。
 */
public class JDKProxy implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //本方法中的其他输出输入增强
        System.out.println("方法触发了");
        //执行被代理类 原方法
        Object invoke = method.invoke(target, args);
        System.out.println("执行完毕了");
        return invoke;
    }
}
