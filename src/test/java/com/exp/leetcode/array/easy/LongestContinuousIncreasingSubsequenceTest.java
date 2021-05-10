package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestContinuousIncreasingSubsequenceTest {
  @Test
  void test1() {
    final LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence =
        new LongestContinuousIncreasingSubsequence();

    int[] nums = {1, 3, 5, 4, 7};

    int expect = 3;

    Assertions.assertEquals(expect, longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
  }

  @Test
  void test2() {
    final LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence =
        new LongestContinuousIncreasingSubsequence();

    int[] nums = {2, 2, 2, 2, 2};

    int expect = 1;

    Assertions.assertEquals(expect, longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
  }

  @Test
  void test3() {
    final LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence =
        new LongestContinuousIncreasingSubsequence();

    int[] nums = {};

    int expect = 0;

    Assertions.assertEquals(expect, longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
  }

  @Test
  void test4() {
    final LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence =
        new LongestContinuousIncreasingSubsequence();

    int[] nums = {1};

    int expect = 1;

    Assertions.assertEquals(expect, longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
  }

  @Test
  void test5() {
    final LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence =
        new LongestContinuousIncreasingSubsequence();

    int[] nums = {1, -1, 2};

    int expect = 2;

    Assertions.assertEquals(expect, longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
  }
}
