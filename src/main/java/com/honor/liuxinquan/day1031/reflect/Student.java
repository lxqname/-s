package com.honor.liuxinquan.day1031.reflect;

public class Student {
    private Integer id;
    private String name;
    private Integer class_id;

    public Student() {
    }

    public Student(Integer id, String name, Integer class_id) {
        this.id = id;
        this.name = name;
        this.class_id = class_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public void show1(String s) {
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }

    private String show2(int age) {
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", class_id=" + class_id +
                '}';
    }
}

