package com.github.books.javacore1.chapterDemo.o12.producterCustomer;

public class Customer implements Runnable {
    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}
