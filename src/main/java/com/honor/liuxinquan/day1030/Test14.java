package com.honor.liuxinquan.day1030;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：
 * 要求：
 *     1 访问修饰符必须为public，不写默认为public；
 *     2 该元素的类型只能是基本数据类型、String、Class、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一位数组；
 *     3 该元素的名称一般定义为名词，如果注解中只有一个元素，请把名字起为value（后面使用会带来便利操作）；
 *      ()不是定义方法参数的地方，也不能在括号中定义任何参数，仅仅只是一个特殊的语法；
 *     4 default代表默认值，值必须和第2点定义的类型一致；
 *     5 如果没有默认值，代表后续使用注解时必须给该类型元素赋值。
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Test14 {
    String name();
    int age() default 0;

}
/**
 *@Target注解:
 *  ElementType中：Type：类，接口（包括注解类型）或枚举的声明
 *                FIELD：属性的声明
 *                METHOD：方法的声明
 *  ElementType中标记用在什么地方；
 *
 * @Retention注解，
 *          翻译为持久力、保持力。即用来修饰自定义注解的生命力。
 *          注解的生命周期有三个阶段：1、Java源文件阶段；2、编译到class文件阶段；3、运行期阶段。
 */