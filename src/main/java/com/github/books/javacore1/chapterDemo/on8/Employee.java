package com.github.books.javacore1.chapterDemo.on8;

import java.util.Date;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private int age;
    private Date hireDay;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee clone = (Employee) super.clone();
        clone.hireDay = (Date) hireDay.clone();
        return clone;
    }

    public String toString() {
        return "时间： [" + name + salary + hireDay + "\t" + age + " ]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
