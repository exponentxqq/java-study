package com.study.socket.discover.server;

import com.study.socket.discover.Constant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** @date 2021/6/13 14:39 */
public class Server {
  public static void main(String[] args) throws IOException {
    final TcpServer tcpServer = new TcpServer(Constant.TCP_SERVER_PORT);
    tcpServer.start();

    final UdpServer udpServer = new UdpServer();
    udpServer.start(Constant.UDP_SERVER_PORT);

    final InputStream in = System.in;
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(in));

    String line = "";
    do {
      line = inputReader.readLine();
      tcpServer.broadcast(line);
    } while (!"00bye00".equalsIgnoreCase(line));

    udpServer.close();
    tcpServer.close();
  }
}
