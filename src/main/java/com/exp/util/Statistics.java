package com.exp.util;

public class Statistics {
  public static void run(Runnable runnable) {
    System.out.println("start...");
    long startTime = System.currentTimeMillis();
    runnable.run();
    System.out.println("used " + (System.currentTimeMillis() - startTime));
  }

  public static void run(Runnable runnable, int times) {
    System.out.println("start...");
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < times; i++) {
      runnable.run();
    }
    System.out.println("used " + (System.currentTimeMillis() - startTime) / 1000F + "s");
  }
}
