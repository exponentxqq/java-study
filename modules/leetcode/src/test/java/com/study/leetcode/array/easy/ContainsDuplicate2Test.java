package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/25 1:38 AM */
public class ContainsDuplicate2Test {
  @Test
  void test1() {
    ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();

    int[] nums = {1, 2, 3, 1};
    int k = 3;

    boolean expect = true;

    Assertions.assertEquals(expect, containsDuplicate2.containsNearbyDuplicate2(nums, k));
  }

  @Test
  void test2() {
    ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();

    int[] nums = {1, 0, 1, 1};
    int k = 1;

    boolean expect = true;

    Assertions.assertEquals(expect, containsDuplicate2.containsNearbyDuplicate2(nums, k));
  }

  @Test
  void test3() {
    ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();

    int[] nums = {1, 2, 3, 1, 2, 3};
    int k = 2;

    boolean expect = false;

    Assertions.assertEquals(expect, containsDuplicate2.containsNearbyDuplicate2(nums, k));
  }
}
