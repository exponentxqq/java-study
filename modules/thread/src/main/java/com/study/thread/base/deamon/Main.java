package com.study.thread.base.deamon;

import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("程序开始，当前main线程：" + Thread.currentThread().getName());
    for (int i = 1; i <= 1; i++) {
      Thread thread =
          new Thread(
              new PrintStoryRunnable("拘留！员工随手丢烟头 烧了6辆公交车。小伙揭秘：如何用AI修复百年前的京城影像", 200 * i),
              "我的线程" + i);
      // 可以在start之前设置线程为守护线程
      // 守护线程不会影响进程终止
      // 进程终止的条件：所有非守护线程结束，则进程结束
      thread.setDaemon(true);

      // 可以改变线程的优先级，但是不一定有效
      thread.setPriority(Thread.MAX_PRIORITY);
      thread.start();
    }
    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
    // 当main线程退出时，程序只剩下身为守护线程的子线程，此时进程会直接退出，不会等待子线程执行完毕
    System.out.println("程序结束，main线程：" + Thread.currentThread().getName());
  }
}

class PrintStoryRunnable implements Runnable {
  private String text;
  private long interval;

  public PrintStoryRunnable(String text, long interval) {
    this.text = text;
    this.interval = interval;
  }

  private static void printSlowly(String text, long interval) throws InterruptedException {
    for (char ch : text.toCharArray()) {
      Thread.sleep(interval);
      System.out.print(ch);
    }
    Thread.sleep(interval);
    System.out.println();
  }

  @Override
  public void run() {
    try {
      System.out.println("子线程名称：" + Thread.currentThread().getName());
      printSlowly(text, interval);
      System.out.println("子线程结束：" + Thread.currentThread().getName());
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
