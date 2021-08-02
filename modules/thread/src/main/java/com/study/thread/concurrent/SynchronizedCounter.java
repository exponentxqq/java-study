package com.study.thread.concurrent;

import lombok.AllArgsConstructor;

public class SynchronizedCounter {
  public static void main(String[] args) throws InterruptedException {
    NormalInt a = new NormalInt(0);
    final Thread thread1 =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                a.incr();
              }
            });
    final Thread thread2 =
        new Thread(
            () -> {
              for (int i = 0; i < 10000; i++) {
                a.incr();
              }
            });
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("multi thread test result: " + a.get());
  }
}

@AllArgsConstructor
class NormalInt {
  private int value;

  public synchronized void incr() {
    value++;
  }

  public int get() {
    return value;
  }
}
