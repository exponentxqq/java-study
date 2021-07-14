package com.exp.book.nettyauthoritative.chapter2.threadsyncblock;

import com.exp.book.nettyauthoritative.chapter2.syncblock.TimeServerHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过线程池，实现伪异步 I/O
 *
 * @tag thread,thread-pool,task,io
 */
public class TimeServer {
  public static void main(String[] args) throws IOException {
    int port = 8020;
    if (args != null && args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    try (final ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("time server is start in port: " + port);

      final TimeServerHandlerExecutePool timeServerHandlerExecutePool =
          new TimeServerHandlerExecutePool(50, 10000);

      while (true) {
        timeServerHandlerExecutePool.execute(new TimeServerHandler(serverSocket.accept()));
      }
    } catch (IOException e) {
      throw e;
    } finally {
      System.out.println("time server is closed");
    }
  }
}

class TimeServerHandlerExecutePool {
  private ExecutorService executor;

  public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
    executor =
        new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            maxPoolSize,
            120L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(queueSize));
  }

  public void execute(Runnable task) {
    executor.execute(task);
  }
}
