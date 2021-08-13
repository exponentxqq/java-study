package com.study.thread.lock;

import lombok.extern.slf4j.Slf4j;

public class DeadLock {
  public static void main(String[] args) {
    final Object lock1 = new Object();
    final Object lock2 = new Object();
    new Thread1(lock1, lock2).start();
    new Thread2(lock1, lock2).start();
  }
}

@Slf4j
class Thread1 extends Thread {
  private final Object lock1;
  private final Object lock2;

  public Thread1(Object lock1, Object lock2) {
    this.lock1 = lock1;
    this.lock2 = lock2;
    setName(getClass().getName());
  }

  @Override
  public void run() {
    fun();
  }

  // 锁1拿2
  private void fun() {
    synchronized (lock1) {
      try {
        Thread.sleep(2);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
      synchronized (lock2) {
      }
    }
  }
}

@Slf4j
class Thread2 extends Thread {
  private final Object lock1;
  private final Object lock2;

  public Thread2(Object lock1, Object lock2) {
    this.lock1 = lock1;
    this.lock2 = lock2;
    setName(getClass().getName());
  }

  @Override
  public void run() {
    fun();
  }

  // 锁2拿1
  private void fun() {
    synchronized (lock2) {
      try {
        Thread.sleep(2);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
      synchronized (lock1) {
      }
    }
  }
}
