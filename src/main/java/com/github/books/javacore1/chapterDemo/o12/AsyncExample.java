package com.github.books.javacore1.chapterDemo.o12;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncExample {
    public static void main(String[] args) throws Exception {
        // 创建一个异步任务，计算1+2的结果
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
//                TimeUnit.SECONDS.sleep(1); // 模拟耗时操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1 + 2;
        });

        // 在异步任务完成后执行其他操作
        future.thenAccept((result) -> {
            System.out.println("异步任务执行结果：" + result);
        });

        // 阻塞主线程，等待异步任务完成
        future.get();
    }
}
