package com.github.books.javacore1.chapterDemo.o12.Thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyRunnable1 mr1 = new MyRunnable1();
        Thread t = new Thread(mr1);
        t.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 20) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
