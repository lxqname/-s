package com.honor.liuxinquan.day1104.jdk;

import net.sf.cglib.proxy.Proxy;

public class Test1 {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        JDKProxy jdkProxy = new JDKProxy(user);
        // 第二个入参 interfaces就是需要代理实例实现的接口列表.
        user= (UserImpl)Proxy.newProxyInstance(user.getClass().getClassLoader(),
                user.getClass().getInterfaces(), jdkProxy);
        user.login();
        user.loginOut();
    }
}
