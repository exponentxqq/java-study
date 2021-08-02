package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FairCandySwapTest {
  @Test
  void test1() {
    final FairCandySwap fairCandySwap = new FairCandySwap();

    int[] A = {1, 1};
    int[] B = {2, 2};

    int[] expected = {1, 2};

    Assertions.assertArrayEquals(expected, fairCandySwap.fairCandySwap(A, B));
  }

  @Test
  void test2() {
    final FairCandySwap fairCandySwap = new FairCandySwap();

    int[] A = {1, 2};
    int[] B = {2, 3};

    int[] expected = {1, 2};

    Assertions.assertArrayEquals(expected, fairCandySwap.fairCandySwap(A, B));
  }

  @Test
  void test3() {
    final FairCandySwap fairCandySwap = new FairCandySwap();

    int[] A = {2};
    int[] B = {1, 3};

    int[] expected = {2, 3};

    Assertions.assertArrayEquals(expected, fairCandySwap.fairCandySwap(A, B));
  }

  @Test
  void test4() {
    final FairCandySwap fairCandySwap = new FairCandySwap();

    int[] A = {1, 2, 5};
    int[] B = {2, 4};

    int[] expected = {5, 4};

    Assertions.assertArrayEquals(expected, fairCandySwap.fairCandySwap(A, B));
  }
}
