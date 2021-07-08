package com.exp.socket.tcp.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @date 2021/7/8 00:25 */
public class HttpServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8801);
    ExecutorService executorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        executorService.execute(() -> service(socket));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void service(Socket socket) {
    try {
      final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
      printWriter.println("HTTP/1.1 200 OK");
      printWriter.println("Content-Type:text/html;charset-utf-8");
      String body = "hello nio";
      printWriter.println("Content-Length:" + body.getBytes().length);
      printWriter.println();
      printWriter.write(body);
      printWriter.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
