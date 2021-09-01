package com.study.thread.base.interrupt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("程序开始，当前main线程：" + Thread.currentThread().getName());
    List<Thread> threads = new ArrayList<>();
    for (int i = 1; i <= 1; i++) {
      Thread thread = new Thread(new NotHandleInterrupt(TimeUnit.SECONDS.toMillis(8)), "我的线程" + i);
      // 子线程如果在sleep，会抛出InterruptedException
      // Thread thread = new Thread(new PrintStoryRunnable(TEXT, 200 * i), "我的线程" + i);
      thread.start();
      threads.add(thread);
    }
    // 在main线程sleep的5秒内，子线程运行正常
    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
    System.out.println();

    System.out.println("开始interrupt线程");
    // interrupt是一个标识，需要thread里执行的代码自己去检查
    // 如果线程不是在sleep，或者没有执行一些确实处理这个状态的方法，那么调用interrupt方法没有任何作用
    // 当发送interrupt信号的时候，子线程如果在sleep，会抛出InterruptedException
    threads.forEach(Thread::interrupt);

    System.out.println("interrupt结束");
    Thread.sleep(TimeUnit.SECONDS.toMillis(5));

    System.out.println("程序结束，main线程：" + Thread.currentThread().getName());
  }

  static class NotHandleInterrupt implements Runnable {
    private long duration;

    public NotHandleInterrupt(long duration) {
      this.duration = duration;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + "开始执行");
      long start = System.currentTimeMillis();
      long counter = 0;
      boolean isInterrupted = Thread.currentThread().isInterrupted();
      System.out.println(Thread.currentThread().getName() + "的isInterrupted=" + isInterrupted);
      // 死循环获取interrupt的变动
      while (true) {
        counter++;
        if (isInterrupted != Thread.currentThread().isInterrupted()) {
          isInterrupted = Thread.currentThread().isInterrupted();
          System.out.println(
              "发现线程" + Thread.currentThread().getName() + "的isInterrupted变化为：" + isInterrupted);
          System.out.println("但是线程决定什么都不做");
        }
        if (System.currentTimeMillis() - start > duration) {
          break;
        }
      }
      System.out.println("线程结束：" + Thread.currentThread().getName());
    }
  }
}
