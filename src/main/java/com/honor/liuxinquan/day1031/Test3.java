package com.honor.liuxinquan.day1031;

/**
 * 单例模式：
 */
public class Test3 {
    public static void main(String[] args) {

    }
}

/**
 * 懒汉式：私有化构造方法，私有化当前对象属性
 * 提供静态方法，判断静态属性是否存在，不存在则创建，返回静态对象属性
 */
class Single1 {
    private Single1() {
    }

    ;
    private static Single1 single1;

    public static Single1 getSingle1() {
        if (single1 == null) {
            Single1 single1 = new Single1();
        }
        return single1;
    }
}

/**
 * 饿汉式：私有化构造方法，私有化静态属性，并且实例化对象
 * 提供静态方法，直接返回当前静态对象的属性
 */
class Single2 {
    private Single2() {
    }

    ;
    private static Single2 single2 = new Single2();

    public static Single2 getSingle2() {
        return single2;
    }
}
