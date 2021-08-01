package com.exp.jvm.gc;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/** @date 2021/6/27 18:00 */
public class GCLogAnalysis {
  private static final Random random = new Random();

  public static void main(String[] args) {
    final long start = System.currentTimeMillis();
    final long timeout = TimeUnit.SECONDS.toMillis(1);
    final long end = start + timeout;
    final LongAdder counter = new LongAdder();
    System.out.println("processing......");

    int cacheSize = 2000;
    int count = 0;
    final Object[] cachedGarbage = new Object[cacheSize];
    while (System.currentTimeMillis() < end) {
      final Object garbage = generateGarbage(100 * 1024);
      counter.increment();
      final int randomIndex = random.nextInt(2 * cacheSize);
      if (randomIndex < cacheSize) {
        cachedGarbage[randomIndex] = garbage;
        count++;
      }
    }
    System.out.println("done! object generate times: " + counter.longValue());
    System.out.println("alive object count:" + count);
  }

  private static Object generateGarbage(int max) {
    int randomSize = random.nextInt(max);
    int type = randomSize % 4;
    Object result = null;
    switch (type) {
      case 0:
        result = new int[randomSize];
        break;
      case 1:
        result = new byte[randomSize];
        break;
      case 2:
        result = new double[randomSize];
        break;
      case 3:
      default:
        final StringBuilder builder = new StringBuilder();
        String randomString = "randomString-Anything";
        while (builder.length() < randomSize) {
          builder.append(randomString);
          builder.append(max);
          builder.append(randomSize);
        }
        result = builder.toString();
        break;
    }
    return result;
  }
}
