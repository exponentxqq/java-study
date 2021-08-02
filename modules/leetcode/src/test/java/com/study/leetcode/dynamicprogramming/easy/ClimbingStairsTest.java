package com.study.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClimbingStairsTest {
  @Test
  void test1() {
    final ClimbingStairs climbingStairs = new ClimbingStairs();

    int n = 2;

    int expected = 2;

    Assertions.assertEquals(expected, climbingStairs.climbStairs(n));
  }

  @Test
  void test2() {
    final ClimbingStairs climbingStairs = new ClimbingStairs();

    int n = 3;

    int expected = 3;

    Assertions.assertEquals(expected, climbingStairs.climbStairs(n));
  }
}
