package com.study.thread.sync.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParallelCompletableFutureTest {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    parallel();
  }

  private static void parallel() throws InterruptedException {
    final CompletableFuture<String> queryCodeFutureA =
        CompletableFuture.supplyAsync(() -> queryCode("阿里巴巴", "https://www.aaa.com"));
    final CompletableFuture<String> queryCodeFutureB =
        CompletableFuture.supplyAsync(() -> queryCode("阿里巴巴", "https://www.bbb.com"));
    final CompletableFuture<Object> queryCodeFuture =
        CompletableFuture.anyOf(queryCodeFutureA, queryCodeFutureB);

    final CompletableFuture<Double> fetchPriceFutureA =
        queryCodeFuture.thenApplyAsync(code -> fetchPrice((String) code, "https://www.aaa.com"));
    final CompletableFuture<Double> fetchPriceFutureB =
        queryCodeFuture.thenApplyAsync(code -> fetchPrice((String) code, "https://www.bbb.com"));
    final CompletableFuture<Object> fetchPriceFuture =
        CompletableFuture.anyOf(fetchPriceFutureA, fetchPriceFutureB);

    fetchPriceFuture.thenAccept(result -> System.out.println("price:" + result));
    Thread.sleep(1000);
  }

  private static String queryCode(String name, String url) {
    System.out.println("query " + name + " code from " + url + "...");
    try {
      Thread.sleep((long) (Math.random() * 100));
    } catch (InterruptedException ignored) {
      // ignore
    }
    return "888888";
  }

  private static Double fetchPrice(String code, String url) {
    System.out.println("query " + code + " price from " + url);
    try {
      Thread.sleep((long) (Math.random() * 100));
    } catch (InterruptedException ignored) {
      // ignore
    }
    return 5 * Math.random() * 20;
  }
}
