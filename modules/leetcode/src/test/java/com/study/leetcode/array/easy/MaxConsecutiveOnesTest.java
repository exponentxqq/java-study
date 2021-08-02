package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnesTest {
  @Test
  void test1() {
    final MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();

    int[] nums = {1, 1, 0, 1, 1, 1};

    int expect = 3;

    Assertions.assertEquals(expect, maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
  }

  @Test
  void test2() {
    final MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();

    int[] nums = {1, 1, 0, 1, 1, 1, 0};

    int expect = 3;

    Assertions.assertEquals(expect, maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
  }
}
