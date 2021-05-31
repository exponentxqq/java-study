package com.exp.book.nettyauthoritative.chapter2.nio;

import com.google.common.base.Strings;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Set;
import lombok.SneakyThrows;

public class TimeServer {
  public static void main(String[] args) {
    int port = 8020;
    if (args != null && args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    final MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
    new Thread(multiplexerTimeServer, "NIO-TimeServer-001").start();
  }
}

class MultiplexerTimeServer implements Runnable {
  private static final int backlog = 1024;

  private Selector selector;
  private ServerSocketChannel serverSocketChannel;
  private volatile boolean stop = false;

  /** 初始化多路复用，绑定监听端口 */
  public MultiplexerTimeServer(int port) {
    try {
      selector = Selector.open();
      serverSocketChannel = ServerSocketChannel.open();
      serverSocketChannel.configureBlocking(false);
      serverSocketChannel.socket().bind(new InetSocketAddress(port), backlog);
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      System.out.println("time server is start in port: " + port);
    } catch (IOException e) {
      System.exit(1);
    }
  }

  public void stop() {
    stop = true;
  }

  @SneakyThrows
  @Override
  public void run() {
    while (!stop) {
      try {
        selector.select(1000);
        final Set<SelectionKey> selectionKeys = selector.selectedKeys();

        while (selectionKeys.iterator().hasNext()) {
          final SelectionKey key = selectionKeys.iterator().next();
          selectionKeys.iterator().remove();

          try {
            handle(key);
          } finally {
            key.cancel();
            key.channel().close();
          }
        }
      } catch (Exception e) {
        try {
          selector.close();
        } catch (IOException ioe) {
          throw ioe;
        }
      }
    }
  }

  private void handle(SelectionKey key) throws IOException {
    if (key.isValid()) {
      if (key.isAcceptable()) {
        final ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        final SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
      }
      if (key.isReadable()) {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        final ByteBuffer readBuffer = ByteBuffer.allocate(backlog);
        int readBytes = socketChannel.read(readBuffer);
        if (readBytes > 0) {
          readBuffer.flip();
          final byte[] bytes = new byte[readBuffer.remaining()];
          readBuffer.get(bytes);
          final String body = new String(bytes, StandardCharsets.UTF_8);
          System.out.println("time server receive order: " + body);
          doWrite(
              socketChannel,
              "query time order".equals(body) ? Instant.now().toString() : "bad order");
        } else if (readBytes < 0) {
          key.cancel();
          socketChannel.close();
        }
      }
    }
  }

  private void doWrite(SocketChannel socketChannel, String response) throws IOException {
    if (Strings.isNullOrEmpty(response)) {
      final byte[] bytes = response.getBytes();
      final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
      writeBuffer.put(bytes);
      writeBuffer.flip();
      socketChannel.write(writeBuffer);
    }
  }
}