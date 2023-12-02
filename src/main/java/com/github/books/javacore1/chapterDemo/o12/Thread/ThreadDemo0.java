package com.github.books.javacore1.chapterDemo.o12.Thread;

public class ThreadDemo0 extends Thread {
    private boolean flag = true;

    public static void main(String[] args) {
        ThreadDemo0 t = new ThreadDemo0();
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == 5) {
                flag = false;
            }
        }
    }
}
