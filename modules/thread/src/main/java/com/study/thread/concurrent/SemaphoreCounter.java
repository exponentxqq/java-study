package com.study.thread.concurrent;

import java.util.concurrent.Semaphore;

/** @date 2021/8/2 01:26 */
public class SemaphoreCounter {
  public static void main(String[] args) throws InterruptedException {
    final SemaphoreNum a = new SemaphoreNum();
    Thread thread1 = new Thread(a::incr);
    Thread thread2 = new Thread(a::incr);

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("semaphore test result: " + a.getValue());
  }
}

class SemaphoreNum {
  private int value = 0;
  private Semaphore readSemaphore = new Semaphore(100, true);
  private Semaphore writeSemaphore = new Semaphore(1);

  public void incr() {
    for (int i = 0; i < 10000; i++) {
      try {
        writeSemaphore.acquireUninterruptibly();
        value++;
      } finally {
        writeSemaphore.release();
      }
    }
  }

  public int getValue() {
    try {
      readSemaphore.acquireUninterruptibly();
      return value;
    } finally {
      readSemaphore.release();
    }
  }
}
