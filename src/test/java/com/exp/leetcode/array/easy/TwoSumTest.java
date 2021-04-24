package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @date 2021/4/24 3:56 PM
 */
public class TwoSumTest {
  @Test
  void test1() {
    TwoSum twoSum = new TwoSum();

    int[] nums = {2, 5, 46, 13, 45};
    int target = 18;

    int[] expect = {1, 3};

    Assertions.assertArrayEquals(expect, twoSum.twoSum1(nums, target));
    Assertions.assertArrayEquals(expect, twoSum.twoSum2(nums, target));
  }
}
