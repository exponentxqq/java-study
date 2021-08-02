package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeightCheckerTest {
  @Test
  void test1() {
    final HeightChecker heightChecker = new HeightChecker();

    int[] heights = {1, 1, 4, 2, 1, 3};

    int expected = 3;

    Assertions.assertEquals(expected, heightChecker.heightChecker(heights));
  }

  @Test
  void test2() {
    final HeightChecker heightChecker = new HeightChecker();

    int[] heights = {5, 1, 2, 3, 4};

    int expected = 5;

    Assertions.assertEquals(expected, heightChecker.heightChecker(heights));
  }

  @Test
  void test3() {
    final HeightChecker heightChecker = new HeightChecker();

    int[] heights = {1, 2, 3, 4, 5};

    int expected = 0;

    Assertions.assertEquals(expected, heightChecker.heightChecker(heights));
  }
}
