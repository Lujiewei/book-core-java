package com.github.books.javacore2.chapterDemo;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (var server = new ServerSocket(9090)) {
            try (var s = server.accept()) {
                InputStream in = s.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String c = bufferedReader.readLine();
                System.out.println(c);
//                byte[] bytes = new byte[1024];
//                int len = 0;
//                while ((len = in.read(bytes)) != -1) {
//                    System.out.println(new String(bytes, 0, len));
//                }

                OutputStream out = s.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
                bufferedWriter.write("hello client 字符流");
                bufferedWriter.flush();
                in.close();
                out.close();
            }
        }
    }
}
