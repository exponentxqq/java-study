package com.exp.socket.discover.client;

import com.exp.socket.discover.domain.ServerInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

/** @date 2021/6/13 15:13 */
@RequiredArgsConstructor
public class TcpClient {
  private final ServerInfo serverInfo;
  private Socket client;

  public void connect() throws IOException {
    client = new Socket();
    client.setSoTimeout(3000);

    client.connect(
        new InetSocketAddress(
            InetAddress.getByName(serverInfo.getAddress()), serverInfo.getPort()));

    System.out.println("connected to server");
    System.out.println("client info: " + client.getLocalAddress() + ":" + client.getLocalPort());
    System.out.println("server info: " + client.getInetAddress() + ":" + client.getPort());

    try {
      final Reader reader = new Reader(client.getInputStream());
      reader.start();
      write();
      reader.close();
    } catch (IOException e) {
      System.out.println("client exception closed: " + e.getMessage());
    }

    client.close();
    System.out.println("client closed.");
  }

  private void write() throws IOException {
    final InputStream in = System.in;
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(in));

    final OutputStream outputStream = client.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    do {
      final String input = inputReader.readLine();
      printStream.println(input);
      if ("00bye00".equalsIgnoreCase(input)) {
        break;
      }
    } while (true);

    inputReader.close();
    printStream.close();
  }

  class Reader extends Thread {
    private boolean done = false;
    private final InputStream inputStream;

    private Reader(InputStream inputStream) {
      this.inputStream = inputStream;
    }

    @Override
    public void run() {
      super.run();
      try (BufferedReader receiveReader = new BufferedReader(new InputStreamReader(inputStream))) {

        do {
          try {
            final String received = receiveReader.readLine();
            if (Objects.isNull(received)) {
              System.out.println("can't received.");
              break;
            }
            System.out.println("received: " + received);
          } catch (SocketTimeoutException ignored) {
          }
        } while (!done);
      } catch (IOException e) {
        if (!done) {
          System.out.println("client exception closed:" + e.getMessage());
        }
      } finally {
        System.out.println("client closed");
      }
    }

    private void close() throws IOException {
      done = true;
      inputStream.close();
    }
  }
}
