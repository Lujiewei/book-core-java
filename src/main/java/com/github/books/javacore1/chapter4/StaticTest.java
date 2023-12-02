package com.github.books.javacore1.chapter4;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.02 2008-04-10
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        var staff = new Employee01[3];

        staff[0] = new Employee01("Tom", 40000);
        staff[1] = new Employee01("Dick", 60000);
        staff[2] = new Employee01("Harry", 65000);

        // print out information about all Employee objects
        for (Employee01 e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        int n = Employee01.getNextId(); // calls static method
        System.out.println("Next available id=" + n);
    }
}

class Employee01 {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee01(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId; // set id to next available id
        nextId++;
    }

    public static int getNextId() {
        return nextId; // returns static field
    }

    public static void main(String[] args) // unit test
    {
        var e = new Employee01("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
