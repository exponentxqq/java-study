package com.study.thread.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lombok.Getter;

/** @date 2021/8/2 00:26 */
public class WriteReadLockerCounter {
  public static void main(String[] args) throws InterruptedException {
    final WRLockNum a = new WRLockNum();
    final Thread thread1 = new Thread(a::incrAndGet);
    final Thread thread2 = new Thread(a::incrAndGet);

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("write-read read-lock test result: " + a.getValue());

    final WRLockNum b = new WRLockNum();
    final Thread thread3 = new Thread(b::incr);
    final Thread thread4 = new Thread(b::incr);

    thread3.start();
    thread4.start();
    thread3.join();
    thread4.join();
    System.out.println("write-read write-lock test result: " + b.getValue());
  }
}

class WRLockNum {
  @Getter private int value = 0;
  private ReadWriteLock lock = new ReentrantReadWriteLock(true);

  public void incr() {
    for (int i = 0; i < 10000; i++) {
      try {
        // 写锁，独占锁，被读锁排斥
        lock.writeLock().lock();
        value++;
      } finally {
        lock.writeLock().unlock();
      }
    }
  }

  public int incrAndGet() {
    try {
      // 读锁，共享锁，保证可见性
      lock.readLock().lock();
      for (int i = 0; i < 10000; i++) {
        ++value;
      }
      return value;
    } finally {
      lock.readLock().unlock();
    }
  }
}
