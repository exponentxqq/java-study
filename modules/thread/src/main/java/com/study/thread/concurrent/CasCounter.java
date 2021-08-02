package com.study.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;

/** @date 2021/8/2 00:13 */
public class CasCounter {
  public static void main(String[] args) throws InterruptedException {
    AtomicInteger a = new AtomicInteger();
    final Thread thread1 = new Thread(new IncrAtomic(a));
    final Thread thread2 = new Thread(new IncrAtomic(a));
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("cas test result: " + a.get());
  }
}

@RequiredArgsConstructor
class IncrAtomic implements Runnable {
  private final AtomicInteger num;

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      num.incrementAndGet();
    }
  }
}
