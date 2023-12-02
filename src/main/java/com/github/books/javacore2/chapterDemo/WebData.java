package com.github.books.javacore2.chapterDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebData {
    public static void main(String[] args) throws Exception {
        // 创建URL对象
        URL url = new URL("http://www.example.com");

        // 打开连接并获取URLConnection对象
        URLConnection connection = url.openConnection();

        // 读取数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 关闭流和连接
        reader.close();
    }
}
