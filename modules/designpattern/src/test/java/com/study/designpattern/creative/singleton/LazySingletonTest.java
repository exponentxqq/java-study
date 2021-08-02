package com.study.designpattern.creative.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LazySingletonTest {
  @Test
  void test() {
    final ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(16, 64, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(16));

    int counter = 1000;
    while (counter-- > 0) {
      if (!threadPoolExecutor.isShutdown()) {
        threadPoolExecutor.execute(() -> LazySingleton.getInstance().incr());
      }
    }

    Assertions.assertEquals(1000, LazySingleton.getInstance().getCount());
  }
}
