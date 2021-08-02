package com.study.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeSumQueryImmutableTest {
  @Test
  void test1() {
    int[] input = {-2, 0, 3, -5, 2, -1};
    final RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(input);

    int left = 0;
    int right = 2;

    int expected = 1;

    Assertions.assertEquals(expected, rangeSumQueryImmutable.sumRange(left, right));
  }
}
