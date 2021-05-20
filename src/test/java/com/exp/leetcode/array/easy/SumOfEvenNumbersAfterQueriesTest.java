package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfEvenNumbersAfterQueriesTest {
  @Test
  void test1() {
    final SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries =
        new SumOfEvenNumbersAfterQueries();

    int[] nums = {1, 2, 3, 4};
    int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

    int[] expected = {8, 6, 2, 4};

    Assertions.assertArrayEquals(
        expected, sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(nums, queries));
  }
}
