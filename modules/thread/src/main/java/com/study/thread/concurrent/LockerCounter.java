package com.study.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;

/** @date 2021/8/2 00:18 */
public class LockerCounter {
  public static void main(String[] args) throws InterruptedException {
    final LockNum a = new LockNum();
    final Thread thread1 = new Thread(a::incr);
    final Thread thread2 = new Thread(a::incr);

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("locker test result: " + a.getValue());
  }
}

class LockNum {
  @Getter private int value = 0;

  private Lock lock = new ReentrantLock(true);

  public void incr() {
    for (int i = 0; i < 10000; i++) {
      try {
        lock.lock();
        value++;
      } finally {
        lock.unlock();
      }
    }
  }
}
