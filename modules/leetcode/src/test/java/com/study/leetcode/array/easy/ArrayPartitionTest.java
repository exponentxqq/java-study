package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayPartitionTest {
  @Test
  void test1() {
    final ArrayPartition arrayPartition = new ArrayPartition();

    int[] nums = {1, 4, 3, 2};

    int expect = 4;

    Assertions.assertEquals(expect, arrayPartition.arrayPairSum(nums));
  }

  @Test
  void test2() {
    final ArrayPartition arrayPartition = new ArrayPartition();

    int[] nums = {6, 2, 6, 5, 1, 2};

    int expect = 9;

    Assertions.assertEquals(expect, arrayPartition.arrayPairSum(nums));
  }
}
