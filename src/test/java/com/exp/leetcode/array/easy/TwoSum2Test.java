package com.exp.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 11:36 PM */
public class TwoSum2Test {
  @Test
  void test1() {
    TwoSum2 twoSum2 = new TwoSum2();

    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] expect = {1, 2};

    Assertions.assertArrayEquals(expect, twoSum2.twoSum2(nums, target));
  }

  @Test
  void test2() {
    TwoSum2 twoSum2 = new TwoSum2();

    int[] nums = {2, 3, 4};
    int target = 6;

    int[] expect = {1, 3};

    Assertions.assertArrayEquals(expect, twoSum2.twoSum2(nums, target));
  }

  @Test
  void test3() {
    TwoSum2 twoSum2 = new TwoSum2();

    int[] nums = {3, 5, 5, 7};
    int target = 10;

    int[] res = twoSum2.twoSum2(nums, target);

    Assertions.assertTrue(List.of(1, 2).contains(res[0]));
    Assertions.assertTrue(List.of(3, 4).contains(res[1]));
  }

  @Test
  void test4() {
    TwoSum2 twoSum2 = new TwoSum2();

    int[] nums = {-1, 0};
    int target = -1;

    int[] expect = {1, 2};

    Assertions.assertArrayEquals(expect, twoSum2.twoSum2(nums, target));
  }
}
