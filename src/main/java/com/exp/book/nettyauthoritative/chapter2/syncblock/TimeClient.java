package com.exp.book.nettyauthoritative.chapter2.syncblock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
  public static void main(String[] args) throws IOException {
    int port = 8020;
    if (args != null && args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    try (final Socket socket = new Socket("127.0.0.1", port);
        final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
      printWriter.println("query time order");
      System.out.println("send order 3 server succeed");
      final String response = bufferedReader.readLine();
      System.out.println("now is : " + response);
    } catch (IOException e) {
      throw e;
    }
  }
}
