package com.study.socket.discover.client;

import com.study.socket.discover.domain.ServerInfo;
import java.io.IOException;
import java.util.Objects;

/** @date 2021/6/13 15:13 */
public class Client {
  public static void main(String[] args) {

    // 客户端通过UDP广播寻找server
    // server接收到客户端的UDP广播后，通过UDP回送TCP地址与端口
    // 客户端根据UDP server回送的TCP地址与端口进行TCP连接
    final UdpClient udpClient = new UdpClient();
    ServerInfo info = null;
    try {
      info = udpClient.search(3000);
    } catch (InterruptedException | IOException e) {
      System.out.println("not found udp server");
    }

    if (Objects.nonNull(info)) {
      System.out.println("find server: " + info.toString());
      final TcpClient tcpClient = new TcpClient(info);
      try {
        tcpClient.connect();
      } catch (IOException e) {
        System.out.println("connect failed: " + e.getMessage());
      }
    }
  }
}
