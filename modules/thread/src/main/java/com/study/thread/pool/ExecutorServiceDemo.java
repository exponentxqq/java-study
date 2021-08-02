package com.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;

public class ExecutorServiceDemo {
  public static void main(String[] args) throws InterruptedException {
    fixedPool();
    scheduledPool();
  }

  // 固定线程数的线程池
  private static void fixedPool() {
    final ExecutorService executorService = Executors.newFixedThreadPool(4);
    // 一次性放入6个任务，由于线程池只有固定的4个线程，
    // 因此，前4个任务会同时执行，等到有线程空闲后，才会执行后面的两个任务
    for (int i = 0; i < 6; i++) {
      executorService.submit(new Task("" + i));
    }
    // shutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成
    executorService.shutdown();
    // shutdownNow()会立刻停止正在执行的任务
    // awaitTermination()则会等待指定的时间让线程池关闭
  }

  private static void scheduledPool() throws InterruptedException {
    final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
    // 一秒后执行
    executorService.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
    // 2秒后开始执行定时任务，没3秒执行一次
    executorService.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
    // 在上一次执行完毕后，等待3秒再开始执行
    executorService.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);

    Thread.sleep(9000);
    executorService.shutdown();
  }
}

@AllArgsConstructor
class Task implements Runnable {
  private final String name;

  @Override
  public void run() {
    System.out.println("start task " + name);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ignored) {
      // ignore
    }
    System.out.println("end task " + name);
  }
}
