package com.exp.book.nettyauthoritative.chapter2.syncblock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class TimeServerHandler implements Runnable {

  private final Socket socket;

  @SneakyThrows
  @Override
  public void run() {

    try (BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
      String body = null;

      while (true) {
        body = bufferedReader.readLine();
        if (body == null) {
          break;
        }

        System.out.println("time server received order: " + body);
        printWriter.println(
            "query time order".equals(body) ? Instant.now().toString() : "bad order");
      }
    } catch (IOException e) {
      socket.close();
    }
  }
}
