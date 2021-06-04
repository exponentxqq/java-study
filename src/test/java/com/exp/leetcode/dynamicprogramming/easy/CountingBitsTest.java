package com.exp.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingBitsTest {
  @Test
  void test1() {
    final CountingBits countingBits = new CountingBits();

    int n = 2;

    int[] expected = {0, 1, 1};

    Assertions.assertArrayEquals(expected, countingBits.countBits(n));
  }

  @Test
  void test2() {
    final CountingBits countingBits = new CountingBits();

    int n = 5;

    int[] expected = {0, 1, 1, 2, 1, 2};

    Assertions.assertArrayEquals(expected, countingBits.countBits(n));
  }
}
