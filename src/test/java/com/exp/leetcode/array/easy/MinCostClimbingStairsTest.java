package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostClimbingStairsTest {
  @Test
  void test1() {
    final MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

    int[] cost = {10, 15, 20};

    int expect = 15;

    Assertions.assertEquals(expect, minCostClimbingStairs.minCostClimbingStairs(cost));
  }

  @Test
  void test2() {
    final MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    int expect = 6;

    Assertions.assertEquals(expect, minCostClimbingStairs.minCostClimbingStairs(cost));
  }
}
