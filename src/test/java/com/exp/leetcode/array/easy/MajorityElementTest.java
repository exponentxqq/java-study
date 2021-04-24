package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/25 12:25 AM */
public class MajorityElementTest {
  @Test
  void test1() {
    MajorityElement majorityElement = new MajorityElement();

    int[] nums = {3, 2, 3};

    int expect = 3;

    Assertions.assertEquals(expect, majorityElement.majorityElement(nums));
  }

  @Test
  void test2() {
    MajorityElement majorityElement = new MajorityElement();

    int[] nums = {2, 2, 1, 1, 1, 2, 2};

    int expect = 2;

    Assertions.assertEquals(expect, majorityElement.majorityElement(nums));
  }
}
