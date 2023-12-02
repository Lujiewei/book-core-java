package com.github.books.javacore1.chapterDemo.on8;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    private String name;
    private int age;

    public Reflection(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Reflection() {
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class<?> clazz = Class.forName("com.github.books.javacore1.chapterDemo.on8.Reflection");

        // 创建对象
        Object obj = clazz.getConstructor().newInstance();

        // 访问字段
        Field field1 = clazz.getDeclaredField("name");
        field1.setAccessible(true); // 如果字段是私有的，需要先设置为可访问
        field1.set(obj, "Tom"); // 设置字段的值

        // 调用方法
        Method method1 = clazz.getDeclaredMethod("sayHello");
        method1.invoke(obj); // 调用方法
    }
}
