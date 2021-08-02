package com.study.book.nettyauthoritative.syncblock;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/** 同步阻塞式 I/O */
public class TimeServer {
  public static void main(String[] args) throws IOException {
    int port = 8020;
    if (args != null && args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    try (final ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("time server is start in port: " + port);
      Socket socket = null;

      while (true) {
        socket = serverSocket.accept();
        System.out.println("client connected");
        new Thread(new TimeServerHandler(socket)).start();
      }
    } finally {
      System.out.println("time server is closed");
    }
  }
}
