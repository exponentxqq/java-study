package com.study.thread.sync;

import lombok.Getter;

public class Demo {
  public static void main(String[] args) {
    final VolatileVal test = new VolatileVal();
    for (int i = 0; i < 10; i++) {
      new Thread(
              () -> {
                for (int j = 0; j < 1000; j++) test.incr();
              })
          .start();
    }

    while (Thread.activeCount() > 1) // 保证前面的线程都执行完
    Thread.yield();
    System.out.println(test.getTest());
  }
}

@Getter
class VolatileVal {
  private volatile int test;

  public void incr() {
    test++;
  }
}

class SyncVal {}
