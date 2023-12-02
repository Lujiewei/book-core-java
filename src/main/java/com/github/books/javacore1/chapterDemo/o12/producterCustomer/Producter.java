package com.github.books.javacore1.chapterDemo.o12.producterCustomer;

public class Producter implements Runnable {

    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                food.set("sss", "sss");
            } else {
                food.set("xxx", "xxx");
            }
        }
    }
}
