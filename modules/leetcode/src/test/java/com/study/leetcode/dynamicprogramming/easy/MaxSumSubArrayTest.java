package com.study.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSumSubArrayTest {
  @Test
  void test1() {
    final MaxSumSubArray maxSumSubArray = new MaxSumSubArray();

    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int expected = 6;

    Assertions.assertEquals(expected, maxSumSubArray.maxSubArray(nums));
  }
}
