package com.study.socket.discover.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @date 2021/6/13 14:40 */
public class TcpServer implements ClientHandlerCallback {
  private final int port;
  private Listener listener;
  private List<TcpClientHandler> clients = new ArrayList<>();
  private final ExecutorService forwardExecutor;

  public TcpServer(int port) {
    this.port = port;
    forwardExecutor = Executors.newSingleThreadExecutor();
  }

  public boolean start() {
    try {
      listener = new Listener(port);
      listener.start();
    } catch (IOException e) {
      return false;
    }
    return true;
  }

  public synchronized void broadcast(String line) {
    System.out.println("broadcast: " + line);
    clients.forEach(client -> client.send(line));
    System.out.println("broadcast " + clients.size() + " client");
  }

  public void close() {
    if (Objects.nonNull(listener)) {
      listener.close();
    }
    synchronized (TcpServer.this) {
      clients.forEach(TcpClientHandler::close);
      clients.clear();
    }
    forwardExecutor.shutdownNow();
  }

  @Override
  public synchronized void onSelfClosed(TcpClientHandler clientHandler) {
    clients.remove(clientHandler);
  }

  @Override
  public void onNewMessageArrived(TcpClientHandler clientHandler, String message) {
    System.out.println("receive: " + clientHandler.getClientInfo() + " ====> " + message);
    forwardExecutor.execute(
        () -> {
          synchronized (TcpServer.this) {
            clients.forEach(
                client -> {
                  if (!client.equals(clientHandler)) {
                    client.send(message);
                  }
                });
          }
          System.out.println("chat send done.");
        });
  }

  class Listener extends Thread {

    private final ServerSocket serverSocket;
    private boolean done = false;

    public Listener(int port) throws IOException {
      this.serverSocket = new ServerSocket(port);
      System.out.println(
          "server["
              + serverSocket.getInetAddress()
              + ":"
              + serverSocket.getLocalPort()
              + "] starting...");
    }

    @Override
    public void run() {
      super.run();
      System.out.println("server ready");
      do {
        Socket client;
        try {
          client = serverSocket.accept();
          TcpClientHandler clientHandler = new TcpClientHandler(client, TcpServer.this);
          clientHandler.read();
          synchronized (TcpServer.this) {
            TcpServer.this.clients.add(clientHandler);
          }
        } catch (IOException ignored) {
        }
      } while (!done);

      System.out.println("server closed.");
    }

    public void close() {
      done = true;
      try {
        serverSocket.close();
      } catch (IOException ignore) {
      }
    }
  }
}
