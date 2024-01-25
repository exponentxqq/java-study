package com.study.thread.summary;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/** 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程 */
@Slf4j
public class Usage {

  public static void main(String[] args) throws Exception {
    log.info("method01: \t{}\t(Thread.join)", method1());
    log.info("method02: \t{}\t(CountDownLatch)", method2());
    log.info("method03: \t{}\t(Semaphore)", method3());
    log.info("method04: \t{}\t(CyclicBarrier)", method4());
    log.info("method05: \t{}\t(Lock)", method5());
    log.info("method06: \t{}\t(while)", method6());
    log.info("method07: \t{}\t(Object.wait/notify)", method7());
    log.info("method08: \t{}\t(FutureTask)", method8());
    log.info("method09: \t{}\t(CompletableFuture.supplyAsync.get)", method9());
    log.info("method10: \t{}\t(ExecutorService)", method10());
    log.info("method11: \t{}\t(CompletionService)", method11());
    log.info("method12: \t{}\t(ArrayBlockingQueue)", method12());
    log.info("method13: \t{}\t(CompletableFuture.supplyAsync.thenAccept.join)", method13());
    log.info("method14: \t{}\t(CompletableFuture.runAsync.join)", method14());
    log.info("method15: \t{}\t(CompletableFuture.supplyAsync.thenApply.join)", method15());
  }

  private static int method1() throws InterruptedException {
    AtomicInteger result = new AtomicInteger();
    final Thread thread =
        new Thread(
            () -> {
              final int res = fibo();
              result.set(res);
            });
    thread.start();
    thread.join();
    return result.get();
  }

  private static int method2() throws InterruptedException {
    AtomicInteger result = new AtomicInteger();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    new Thread(
            () -> {
              result.set(fibo());
              countDownLatch.countDown();
            })
        .start();
    countDownLatch.await();
    return result.get();
  }

  private static int method3() throws InterruptedException {
    final AtomicInteger result = new AtomicInteger();
    final Semaphore semaphore = new Semaphore(1);
    new Thread(
            () -> {
              try {
                semaphore.acquireUninterruptibly();
                result.set(fibo());
              } finally {
                semaphore.release();
              }
            })
        .start();
    Thread.sleep(100);
    semaphore.acquireUninterruptibly();
    return result.get();
  }

  private static int method4() throws Exception {
    final AtomicInteger result = new AtomicInteger();
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    new Thread(
            () -> {
              result.set(fibo());
              try {
                cyclicBarrier.await();
              } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
              }
            })
        .start();
    cyclicBarrier.await();
    return result.get();
  }

  private static int method5() throws InterruptedException {
    final AtomicInteger result = new AtomicInteger();
    Lock lock = new ReentrantLock(true);
    new Thread(
            () -> {
              try {
                lock.lock();
                result.set(fibo());
              } finally {
                lock.unlock();
              }
            })
        .start();
    try {
      Thread.sleep(100);
      lock.lock();
      return result.get();
    } finally {
      lock.unlock();
    }
  }

  private static int method6() {
    AtomicInteger result = new AtomicInteger();
    new Thread(() -> result.set(fibo())).start();
    while (result.get() == 0) {}
    return result.get();
  }

  private static int method7() throws InterruptedException {
    AtomicInteger result = new AtomicInteger();
    new Thread(
            () -> {
              synchronized (result) {
                result.set(fibo());
                result.notifyAll();
              }
            })
        .start();
    synchronized (result) {
      do {
        result.wait(1000);
        break;
      } while (true);
    }
    return result.get();
  }

  private static int method8() throws ExecutionException, InterruptedException {
    Future<Integer> future = new FutureTask<>(Usage::fibo);
    new Thread((Runnable) future).start();
    return future.get();
  }

  private static int method9() throws ExecutionException, InterruptedException {
    final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Usage::fibo);
    return completableFuture.get();
  }

  private static int method10() throws ExecutionException, InterruptedException {
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    try {
      final Future<Integer> future = executorService.submit((Callable<Integer>) Usage::fibo);
      return future.get();
    } finally {
      executorService.shutdown();
    }
  }

  private static int method11() throws InterruptedException, ExecutionException {
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
    completionService.submit(Usage::fibo);
    try {
      final Future<Integer> future = completionService.take();
      return future.get();
    } finally {
      executorService.shutdown();
    }
  }

  private static int method12() throws InterruptedException {
    final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
    new Thread(
            () -> {
              try {
                queue.put(fibo());
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            })
        .start();
    return queue.take();
  }

  private static int method13() {
    AtomicInteger result = new AtomicInteger();
    final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Usage::fibo);
    final CompletableFuture<Void> setResultFuture = completableFuture.thenAccept(result::set);
    setResultFuture.join();
    return result.get();
  }

  private static int method14() {
    AtomicInteger result = new AtomicInteger();
    final CompletableFuture<Void> future = CompletableFuture.runAsync(() -> result.set(fibo()));
    future.join();
    return result.get();
  }

  private static int method15() {
    AtomicInteger result = new AtomicInteger();
    final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Usage::fibo);
    final CompletableFuture<Object> future =
        completableFuture.thenApply(
            res -> {
              result.set(res);
              return null;
            });
    future.join();
    return result.get();
  }

  private static int fibo() {
    return fibo(36);
  }

  private static int fibo(int a) {
    if (a < 2) {
      return 1;
    }
    return fibo(a - 1) + fibo(a - 2);
  }
}
