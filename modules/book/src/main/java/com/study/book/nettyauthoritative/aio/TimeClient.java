package com.study.book.nettyauthoritative.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class TimeClient {
  public static void main(String[] args) throws IOException {
    new Thread(new TimeClientHandler()).start();
  }
}

@Slf4j
class TimeClientHandler implements CompletionHandler<Void, TimeClientHandler>, Runnable {
  private final AsynchronousSocketChannel client;
  private final CountDownLatch countDownLatch;

  public TimeClientHandler() throws IOException {
    try {
      client = AsynchronousSocketChannel.open();
      countDownLatch = new CountDownLatch(1);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      throw e;
    }
  }

  @Override
  public void run() {
    client.connect(new InetSocketAddress("127.0.0.1", 8020), this, this);
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }
    try {
      client.close();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

  @Override
  public void completed(Void result, TimeClientHandler attachment) {
    final byte[] bytes = "query time order".getBytes();
    final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
    writeBuffer.put(bytes);
    writeBuffer.flip();
    client.write(writeBuffer, writeBuffer, new WriteCompletion(client, attachment));
  }

  @Override
  public void failed(Throwable exc, TimeClientHandler attachment) {
    try {
      client.close();
      countDown();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void countDown() {
    countDownLatch.countDown();
  }
}

@RequiredArgsConstructor
@Slf4j
class WriteCompletion implements CompletionHandler<Integer, ByteBuffer> {
  private final AsynchronousSocketChannel client;
  private final TimeClientHandler handler;

  @Override
  public void completed(Integer result, ByteBuffer attachment) {
    if (attachment.hasRemaining()) {
      client.write(attachment, attachment, this);
    } else {
      final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
      client.read(readBuffer, readBuffer, new ReadCompletion(client, handler));
    }
  }

  @Override
  public void failed(Throwable exc, ByteBuffer attachment) {
    try {
      client.close();
      handler.countDown();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
}

@RequiredArgsConstructor
@Slf4j
class ReadCompletion implements CompletionHandler<Integer, ByteBuffer> {
  private final AsynchronousSocketChannel client;
  private final TimeClientHandler handler;

  @Override
  public void completed(Integer result, ByteBuffer attachment) {
    attachment.flip();
    final byte[] bytes = new byte[attachment.remaining()];
    attachment.get(bytes);
    try {
      final String body = new String(bytes, StandardCharsets.UTF_8);
      log.info("now is: " + body);
      handler.countDown();
    } catch (Exception e) {

    }
  }

  @Override
  public void failed(Throwable exc, ByteBuffer attachment) {
    try {
      client.close();
      handler.countDown();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
}
