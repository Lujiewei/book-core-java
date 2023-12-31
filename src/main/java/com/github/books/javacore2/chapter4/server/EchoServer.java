package com.github.books.javacore2.chapter4.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This program implements a simple server that listens to port 8189 and echoes back all
 * client input.
 *
 * @author Cay Horstmann
 * @version 1.22 2018-03-17
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        // establish server socket
        try (var s = new ServerSocket(8189)) {
            // wait for client connection
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (var in = new Scanner(inStream, StandardCharsets.UTF_8)) {
                    var out = new PrintWriter(
                            new OutputStreamWriter(outStream, StandardCharsets.UTF_8),
                            true /* autoFlush */);

                    out.println("Hello! Enter BYE to exit.");

                    // echo client input
                    var done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}
