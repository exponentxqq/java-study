package com.exp.book.nettyauthoritative.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeClientHandler implements Runnable {
  private SocketChannel socketChannel;
  private Selector selector;
  private boolean stop;

  public TimeClientHandler() {
    try {
      selector = Selector.open();
      socketChannel = SocketChannel.open();
      socketChannel.configureBlocking(false);
    } catch (Exception e) {
      log.error("channel open failed: " + e.getMessage());
      System.exit(1);
    }
  }

  @Override
  public void run() {
    try {
      doConnect();
    } catch (Exception e) {
      log.error("connect failed: " + e.getMessage());
      System.exit(1);
    }

    while (!stop) {
      try {
        selector.select(1000);
        final Set<SelectionKey> selectionKeys = selector.selectedKeys();
        final Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

        while (keyIterator.hasNext()) {
          final SelectionKey key = keyIterator.next();
          keyIterator.remove();

          try {
            handleInput(key);
          } catch (Exception e) {
            key.cancel();
            key.channel().close();
          }
        }
      } catch (Exception e) {
        log.error(e.getMessage());
        System.exit(1);
      }
    }

    try {
      selector.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void doConnect() throws IOException {
    if (socketChannel.connect(new InetSocketAddress("127.0.0.1", 8020))) {
      socketChannel.register(selector, SelectionKey.OP_READ);
      doWrite(socketChannel);
    } else {
      socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }
  }

  private void doWrite(SocketChannel socketChannel) throws IOException {
    final byte[] bytes = "query time order".getBytes();
    final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
    writeBuffer.put(bytes);
    writeBuffer.flip();
    socketChannel.write(writeBuffer);

    if (!writeBuffer.hasRemaining()) {
      System.out.println("send order 2 server succeed");
    }
  }

  private void handleInput(SelectionKey key) throws IOException {
    if (key.isValid()) {
      final SocketChannel channel = (SocketChannel) key.channel();
      if (key.isConnectable()) {
        if (socketChannel.finishConnect()) {
          socketChannel.register(selector, SelectionKey.OP_READ);
          doWrite(socketChannel);
        } else {
          System.exit(1);
        }
      }

      if (key.isReadable()) {
        final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        final int readBytes = socketChannel.read(readBuffer);
        if (readBytes > 0) {
          readBuffer.flip();
          final byte[] bytes = new byte[readBuffer.remaining()];
          readBuffer.get(bytes);
          final String body = new String(bytes, StandardCharsets.UTF_8);
          log.info("now is: " + body);
          stop = true;
        } else if (readBytes < 0) {
          key.cancel();
          channel.close();
        }
      }
    }
  }
}
