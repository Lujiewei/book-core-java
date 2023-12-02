package com.github.books.javacore1.chapterDemo.o12.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable2 mr = new MyRunnable2();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();
    }
}

class MyRunnable2 implements Runnable {

    int tickets = 10;
    Object obj = new Object();

    @Override
    public void run() {
//        synchronized (obj) {
//            while (tickets > 0) {
//                tickets--;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("剩余票数：" + tickets + "张");
//            }
//        }
        method();
    }

    //    private synchronized void method() {
//        while (tickets > 0) {
//            tickets--;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("剩余票数：" + tickets + "张");
//        }
//    }
    ReentrantLock lock = new ReentrantLock();

    private void method() {
        lock.lock();
        while (tickets > 0) {
            tickets--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("剩余票数：" + tickets + "张");
        }
        lock.unlock();
    }
}
