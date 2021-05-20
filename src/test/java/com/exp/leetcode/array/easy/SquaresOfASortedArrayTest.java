package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquaresOfASortedArrayTest {
  @Test
  void test1() {
    final SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();

    int[] nums = {-4, -1, 0, 3, 10};

    int[] expected = {0, 1, 9, 16, 100};

    Assertions.assertArrayEquals(expected, squaresOfASortedArray.sortedSquares(nums));
  }
}
