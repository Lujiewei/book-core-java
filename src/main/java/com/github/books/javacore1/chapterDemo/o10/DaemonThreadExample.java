package com.github.books.javacore1.chapterDemo.o10;

public class DaemonThreadExample {
    public static void main(String[] args) {
        // 创建一个新的守护线程
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟耗时操作
                    System.out.println("守护线程开始执行");
                    Thread.sleep(5000); // 休眠5秒
                    System.out.println("守护线程结束执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 将线程设置为守护线程
        daemonThread.setDaemon(true);

        // 启动线程
        daemonThread.start();

        try {
            // 主线程等待一段时间
            Thread.sleep(2000); // 休眠2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
