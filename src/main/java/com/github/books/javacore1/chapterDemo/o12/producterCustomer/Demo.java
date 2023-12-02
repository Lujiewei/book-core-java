package com.github.books.javacore1.chapterDemo.o12.producterCustomer;

public class Demo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter p = new Producter(food);
        Customer c = new Customer(food);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
