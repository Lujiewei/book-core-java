package com.github.books.javacore2.chapterDemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (var socket = new Socket(InetAddress.getLocalHost(), 9090);) {

            OutputStream out = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write("hello, server");
            bufferedWriter.flush();
            socket.shutdownOutput();

            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//            String s = bufferedReader.readLine();
//            System.out.println(s);
//            bufferedReader.close();
        }
    }
}
