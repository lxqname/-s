package com.honor.liuxinquan.day1031.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取反射对象的几种形式
 */
public class Demo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //1.类名。class获取
        Class<Student> studentClass = Student.class;
        try {
            //2.Class.forName("包名")获取
            Class<?> aClass = Class.forName("com.honor.liuxinquan.day1031.reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //3.通过对象获取反射对象
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();

        //4.通过反射对象获取私有属性的对象
        Field name = aClass.getDeclaredField("name");
        //5.取消权限访问
        name.setAccessible(true);
        //6.设置对象的属性
        name.set(student, "gg");
        System.out.println(student);
        //获取所有公有的字段
        Field[] fields = aClass.getFields();
        //获取所有的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        //获取所有方法
        Method[] methods = aClass.getMethods();
        for (Method s : methods) {
            System.out.println(s);
        }
        //通过反射对象获取构造方法对象
        Constructor<? extends Student> constructor = aClass.getConstructor(null);
        Student student1 = constructor.newInstance();
        System.out.println(student1);
        //通过反射对象获取共有的方法对象
        Method show1 = aClass.getMethod("show1", String.class);
        show1.invoke(student1, "ll");
        System.out.println(show1);
        //通过反射对象获取私有的方法对象
        Method show2 = aClass.getDeclaredMethod("show2", int.class);
        //私有的都需要设置取消权限
        show2.setAccessible(true);
        show2.invoke(student, 1);
        System.out.println(show2);
    }

    /**
     * 反射重写toString
     *
     * @return
     */
    @Override
    public String toString() {
        //1.获得反射对象
        Class<? extends Demo1> aClass = this.getClass();
        StringBuffer stringBuffer = new StringBuffer();
        //2.获得类名并拼接
        String name = aClass.getSimpleName();
        stringBuffer.append(name + "{");
        //3.获得所有属性
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields) {
            //4.获得属性名并拼接
            stringBuffer.append(f.getName() + "=");
            //5.取消访问权限
            f.setAccessible(true);
            try {
                //7.获取属性值并拼接
                stringBuffer.append(f.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (f == fields[fields.length - 1]) {
                stringBuffer.append("}");
            } else {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }
}
