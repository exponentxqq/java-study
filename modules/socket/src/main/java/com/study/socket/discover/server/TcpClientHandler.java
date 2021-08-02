package com.study.socket.discover.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Getter;

/** @date 2021/6/13 14:45 */
public class TcpClientHandler {
  private final Socket client;
  private final Reader reader;
  private final Writer writer;
  private final ClientHandlerCallback clientHandlerCallback;
  @Getter private final String clientInfo;

  public TcpClientHandler(Socket socket, ClientHandlerCallback clientHandlerCallback)
      throws IOException {
    this.client = socket;
    this.reader = new Reader(socket.getInputStream());
    this.writer = new Writer(socket.getOutputStream());
    this.clientHandlerCallback = clientHandlerCallback;
    this.clientInfo = client.getInetAddress() + ":" + client.getPort();
  }

  public void read() {
    reader.start();
  }

  public void send(String line) {
    writer.send(line);
  }

  public void close() {
    try {
      client.close();
      reader.close();
      writer.close();
      System.out.println("client closed: " + client.getInetAddress() + ":" + client.getPort());
    } catch (IOException e) {
      System.out.println("client close failed: " + e.getMessage());
    }
  }

  private void closeBySelf() {
    close();
    clientHandlerCallback.onSelfClosed(this);
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
          final String received = receiveReader.readLine();
          if (Objects.isNull(received)) {
            System.out.println("can't received.");
            TcpClientHandler.this.closeBySelf();
            break;
          }
          clientHandlerCallback.onNewMessageArrived(TcpClientHandler.this, received);
        } while (!done);
      } catch (IOException e) {
        if (!done) {
          System.out.println("client exception closed:" + e.getMessage());
          TcpClientHandler.this.closeBySelf();
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

  class Writer extends Thread {
    private boolean done = false;
    private final PrintStream printStream;
    private final ExecutorService executorService;

    public Writer(OutputStream outputStream) {
      this.printStream = new PrintStream(outputStream);
      this.executorService = Executors.newSingleThreadExecutor();
    }

    private void send(String line) {
      if (done) {
        return;
      }
      executorService.execute(
          () -> {
            if (!done) {
              printStream.println(line);
            }
          });
    }

    private void close() {
      done = true;
      printStream.close();
      executorService.shutdownNow();
    }
  }
}
