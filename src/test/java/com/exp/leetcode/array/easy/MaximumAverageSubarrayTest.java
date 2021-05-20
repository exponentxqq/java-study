package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumAverageSubarrayTest {
  @Test
  void test1() {
    final MaximumAverageSubarray maximumAverageSubarray = new MaximumAverageSubarray();

    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;

    double expect = 12.75;

    Assertions.assertEquals(expect, maximumAverageSubarray.findMaxAverage(nums, k));
  }

  @Test
  void test2() {
    final MaximumAverageSubarray maximumAverageSubarray = new MaximumAverageSubarray();

    int[] nums = {5};
    int k = 1;

    double expect = 5;

    Assertions.assertEquals(expect, maximumAverageSubarray.findMaxAverage(nums, k));
  }
}
