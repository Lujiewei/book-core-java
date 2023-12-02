package com.github.books.javacore1.chapter6.clone;

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);
        Employee copy = original.clone();
        System.out.println("copy=" + copy + ", original=" + original);
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
