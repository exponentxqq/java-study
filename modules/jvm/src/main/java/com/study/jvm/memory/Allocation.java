package com.study.jvm.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * VM参数：-verbose:gc -Xms30M -Xmx30M -Xmn20M -XX:+UseParallelGC -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 */
@Slf4j
public class Allocation {
  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    allocate();
  }

  private static void allocate() {
    final byte[] bytes = new byte[_1MB * 2];
    createBigBytes();
    log.info("11111111111111111111");
    final byte[] bytes1 = new byte[_1MB * 2];
    createBigBytes();
    log.info("22222222222222222222");
    final byte[] bytes2 = new byte[_1MB * 2];
  }

  private static void createBigBytes() {
    byte[] bytes = new byte[_1MB];
  }
}
