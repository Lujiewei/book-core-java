package com.github.books.javacore1.chapterDemo.o12;

import java.io.*;

public class MyProcess {
    public static void main(String[] args) throws IOException {
        // 创建一个新的进程
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");

        // 启动进程
        Process process = processBuilder.start();

        // 获取进程的输入流和输出流
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        // 向进程发送命令
        writer.write("Hello, World!\n");
        writer.flush();

        // 读取进程的输出
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待进程结束
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

