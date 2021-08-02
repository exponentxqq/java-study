package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonotonicArrayTest {
  @Test
  void test1() {
    final MonotonicArray monotonicArray = new MonotonicArray();

    int[] nums = {1, 2, 2, 3};

    boolean expected = true;

    Assertions.assertEquals(expected, monotonicArray.isMonotonic(nums));
  }

  @Test
  void test2() {
    final MonotonicArray monotonicArray = new MonotonicArray();

    int[] nums = {6, 5, 4, 4};

    boolean expected = true;

    Assertions.assertEquals(expected, monotonicArray.isMonotonic(nums));
  }

  @Test
  void test3() {
    final MonotonicArray monotonicArray = new MonotonicArray();

    int[] nums = {1};

    boolean expected = true;

    Assertions.assertEquals(expected, monotonicArray.isMonotonic(nums));
  }
}
