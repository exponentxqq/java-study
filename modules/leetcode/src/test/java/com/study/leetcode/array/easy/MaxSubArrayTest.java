package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/23 9:12 PM */
public class MaxSubArrayTest {
  @Test
  void test() {
    int[] nums = {-1, 10, -4, 5};
    int expect = 11;

    assertResult(expect, nums);
  }

  private void assertResult(int expect, int[] nums) {
    MaxSubArray maxSubArray = new MaxSubArray();

    Assertions.assertEquals(expect, maxSubArray.maxSubArray1(nums));
    Assertions.assertEquals(expect, maxSubArray.maxSubArray2(nums));
  }
}
