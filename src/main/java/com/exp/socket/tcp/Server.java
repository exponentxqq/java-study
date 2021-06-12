package com.exp.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

/** @date 2021/6/12 22:09 */
public class Server {
  private static final int PORT = 20000;

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = createSocket();
    initSocket(serverSocket);

    System.out.println("server ready");
    System.out.println(
        "server ====> " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());

    while (true) {
      Socket client = serverSocket.accept();
      new ClientHandler(client).start();
    }
  }

  private static ServerSocket createSocket() throws IOException {
    ServerSocket serverSocket = new ServerSocket();
    // 50未允许等待链接的队列为50个
    serverSocket.bind(new InetSocketAddress(Inet4Address.getLocalHost(), PORT), 50);
    return serverSocket;
  }

  private static void initSocket(ServerSocket serverSocket) throws SocketException {
    serverSocket.setReuseAddress(true);
    serverSocket.setReceiveBufferSize(64 * 1024 * 1024);
    // 设置accept超时时间
    serverSocket.setSoTimeout(3000);
    serverSocket.setPerformancePreferences(1, 1, 1);
  }
}

class ClientHandler extends Thread {
  private final Socket socket;
  private boolean stop = false;

  ClientHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    super.run();
    System.out.println("client connected: " + socket.getInetAddress() + ":" + socket.getPort());
    try (OutputStream socketOutputStream = socket.getOutputStream();
        PrintStream socketPrint = new PrintStream(socketOutputStream);
        BufferedReader socketReader =
            new BufferedReader(new InputStreamReader(socket.getInputStream())); ) {
      do {
        String str = socketReader.readLine();
        if ("bye".equalsIgnoreCase(str)) {
          socketPrint.println("bye");
          stop = true;
        } else {
          System.out.println("client send: " + str);
          socketPrint.println("reply: " + str.length());
        }
      } while (!stop);
    } catch (Exception e) {
      System.out.println("client handle error: " + e.getMessage());
      System.out.println(Arrays.toString(e.getStackTrace()));
    }
    System.out.println("client closed: " + socket.getInetAddress() + ":" + socket.getPort());
  }
}
