package com.exp.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

public class IncrTest {
  public static void main(String[] args) throws InterruptedException {
    multiThread();
    cas();
  }

  public static void cas() throws InterruptedException {
    AtomicInteger a = new AtomicInteger();
    final Thread thread1 = new Thread(new IncrAtomic(a));
    final Thread thread2 = new Thread(new IncrAtomic(a));
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("cas test result: " + a.get());
  }

  private static void multiThread() throws InterruptedException {
    NormalInt a = new NormalInt(0);
    final Thread thread1 = new Thread(new IncrInt(a));
    final Thread thread2 = new Thread(new IncrInt(a));
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    System.out.println("multi thread test result: " + a.get());
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

@AllArgsConstructor
class IncrInt implements Runnable {
  private final NormalInt num;

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      num.incr();
    }
  }
}

@AllArgsConstructor
class NormalInt {
  private int value;

  public void incr() {
    value++;
  }

  public int get() {
    return value;
  }
}
