package com.honor.liuxinquan.day1104.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理 :针对所有的类产生代理，
 *            应用的是底层的字节码增强的技术 生成当前类的子类对象
 * @author 86151
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer=new Enhancer();

    /**
     * 给目标对象创建一个代理对象
     */
    public Object setProxy(Class clazz){
        //1.设置父类
        enhancer.setSuperclass(clazz);
        //2.设置回调函数
        enhancer.setCallback(this);
        //3.创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib代理之前之前");
        Object invoke = method.invoke(o, objects);
        System.out.println("CGLib代理之前之后");
        return invoke;
    }
}
