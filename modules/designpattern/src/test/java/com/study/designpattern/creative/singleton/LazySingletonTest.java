package com.study.designpattern.creative.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LazySingletonTest {
  @Test
  void test() throws InterruptedException {
    final ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(16, 64, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000));

    CopyOnWriteArrayList<LazySingleton> list = new CopyOnWriteArrayList<>();
    int counter = 10000;
    CountDownLatch countDownLatch = new CountDownLatch(counter);
    for (int i = 0; i < counter; i++) {
      threadPoolExecutor.execute(
          () -> {
            list.add(LazySingleton.getInstance());
            countDownLatch.countDown();
          });
    }
    countDownLatch.await();
    final LazySingleton first = list.get(0);
    list.forEach(instance -> Assertions.assertEquals(first, instance));
  }
}
