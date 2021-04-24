package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/25 1:17 AM */
public class ContainsDuplicateTest {
  @Test
  void test1() {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    int[] nums = {1, 2, 3, 1};

    boolean expect = true;

    Assertions.assertEquals(expect, containsDuplicate.containsDuplicate2(nums));
  }

  @Test
  void test2() {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    int[] nums = {1, 2, 3, 4};

    boolean expect = false;

    Assertions.assertEquals(expect, containsDuplicate.containsDuplicate2(nums));
  }

  @Test
  void test3() {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

    boolean expect = true;

    Assertions.assertEquals(expect, containsDuplicate.containsDuplicate2(nums));
  }
}
