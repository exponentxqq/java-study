package com.exp.socket.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/** @date 2021/6/14 00:38 */
public class TcpServer {
  private final int port;

  public TcpServer(int port) {
    this.port = port;
  }

  public boolean start() {
    try {
      final Selector selector = Selector.open();
      final ServerSocketChannel server = ServerSocketChannel.open();
      server.configureBlocking(false);
      server.socket().bind(new InetSocketAddress(port));

      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
