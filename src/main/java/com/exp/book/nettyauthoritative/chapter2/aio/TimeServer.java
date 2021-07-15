package com.exp.book.nettyauthoritative.chapter2.aio;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

public class TimeServer {
  public static void main(String[] args) {
    new Thread(new TimeServerHandler()).start();
  }
}

@Slf4j
class TimeServerHandler implements Runnable {
  private final int PORT = 8020;
  CountDownLatch countDownLatch;
  AsynchronousServerSocketChannel serverSocketChannel;

  public TimeServerHandler() {
    try {
      serverSocketChannel = AsynchronousServerSocketChannel.open();
      serverSocketChannel.bind(new InetSocketAddress(PORT));
      log.info("time server is start in port: " + PORT);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

  @Override
  public void run() {
    countDownLatch = new CountDownLatch(1);
    doAccept();
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void doAccept() {
    serverSocketChannel.accept(this, new AcceptCompletionHandler());
  }
}

@Slf4j
class AcceptCompletionHandler
    implements CompletionHandler<AsynchronousSocketChannel, TimeServerHandler> {

  @SneakyThrows
  @Override
  public void completed(AsynchronousSocketChannel result, TimeServerHandler attachment) {
    // 当前客户端接入完成后，后续的客户端的接入处理
    attachment.serverSocketChannel.accept(attachment, this);
    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    log.info("client[" + result.getRemoteAddress() + "] connected.");
    result.read(byteBuffer, byteBuffer, new ReadCompletionHandler(result));
  }

  @Override
  public void failed(Throwable exc, TimeServerHandler attachment) {
    log.error(exc.getMessage(), exc);
    attachment.countDownLatch.countDown();
  }
}

@RequiredArgsConstructor
@Slf4j
class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
  private final AsynchronousSocketChannel channel;

  @Override
  public void completed(Integer result, ByteBuffer attachment) {
    attachment.flip();
    final byte[] bytes = new byte[attachment.remaining()];
    attachment.get(bytes);

    try {
      final String req = new String(bytes, StandardCharsets.UTF_8);
      log.info("time server receive order: " + req);
      final String currentTime =
          "query time order".equals(req) ? Instant.now().toString() : "bad order";
      doWrite(currentTime);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  private void doWrite(String currentTime) {
    if (!StringUtil.isNullOrEmpty(currentTime)) {
      final byte[] bytes = currentTime.getBytes();
      final ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
      byteBuffer.put(bytes);
      byteBuffer.flip();
      channel.write(
          byteBuffer,
          byteBuffer,
          new CompletionHandler<>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
              if (attachment.hasRemaining()) {
                channel.write(byteBuffer, byteBuffer, this);
              }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
              try {
                channel.close();
              } catch (Exception e) {
                log.error(e.getMessage(), e);
              }
            }
          });
    }
  }

  @Override
  public void failed(Throwable exc, ByteBuffer attachment) {
    try {
      channel.close();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
