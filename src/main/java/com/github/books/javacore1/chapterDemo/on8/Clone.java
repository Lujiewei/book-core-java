package com.github.books.javacore1.chapterDemo.on8;

import java.util.*;

public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original1 = new Employee("John Q. Public", 50000, 30);
        Employee original2 = new Employee("John Q. Public", 50000, 10);
        Employee original3 = new Employee("John Q. Public", 50000, 20);
        List<Employee> arr = new ArrayList<>();
        arr.add(original1);
        arr.add(original2);
        arr.add(original3);
        for (Employee a : arr) {
            System.out.println(a);
        }
        Collections.sort(arr, (o1, o2) -> o2.getAge() - o1.getAge());
        for (Employee a : arr) {
            System.out.println(a);
        }
    }


//    @Override
//    public int compare(Employee o1, Employee o2) {
//        return o2.getAge() - o1.getAge();
//    }
}
