package com.study.thread.sync.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SerialCompletableFutureTest {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    exception();
    serial();
  }

  private static void exception() throws ExecutionException, InterruptedException {
    final CompletableFuture<String> queryCodeFuture =
        CompletableFuture.supplyAsync(() -> queryCode("腾讯"));
    final CompletableFuture<String> exceptionFuture =
        queryCodeFuture.exceptionally(Throwable::getMessage);
    // 同步阻塞获取结果
    // final String failedMessage = exceptionFuture.get();
    // System.out.println("failed message: " + failedMessage);
    // 异步回调获取结果，主线程不能退出
    exceptionFuture.thenAccept(message -> System.out.println("failed message: " + message));
    Thread.sleep(1000);
  }

  private static void serial() throws InterruptedException {
    final CompletableFuture<String> queryCodeFuture =
        CompletableFuture.supplyAsync(() -> SerialCompletableFutureTest.queryCode("阿里巴巴"));
    final CompletableFuture<Double> fetchPriceFuture =
        queryCodeFuture.thenApplyAsync(SerialCompletableFutureTest::fetchPrice);
    fetchPriceFuture.thenAccept(price -> System.out.println("price: " + price));
    Thread.sleep(1000);
  }

  private static String queryCode(String name) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException ignore) {
      //  ignroe
    }
    if ("腾讯".equals(name)) {
      throw new RuntimeException("invalid name[" + name + "]");
    }
    return "882828";
  }

  private static Double fetchPrice(String code) {
    try {
      Thread.sleep(200);
    } catch (InterruptedException ignore) {
      //   ignore
    }
    return 5 + Math.random() * 20;
  }
}
