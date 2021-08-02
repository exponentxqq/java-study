package com.study.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheMasseuseLcciTest {
  @Test
  void test1() {
    final TheMasseuseLcci theMasseuseLcci = new TheMasseuseLcci();

    int[] nums = {1, 2, 3, 1};

    int expected = 4;

    Assertions.assertEquals(expected, theMasseuseLcci.massage(nums));
  }

  @Test
  void test2() {
    final TheMasseuseLcci theMasseuseLcci = new TheMasseuseLcci();

    int[] nums = {2, 7, 9, 3, 1};

    int expected = 12;

    Assertions.assertEquals(expected, theMasseuseLcci.massage(nums));
  }

  @Test
  void test3() {
    final TheMasseuseLcci theMasseuseLcci = new TheMasseuseLcci();

    int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};

    int expected = 12;

    Assertions.assertEquals(expected, theMasseuseLcci.massage(nums));
  }

  @Test
  void test4() {
    final TheMasseuseLcci theMasseuseLcci = new TheMasseuseLcci();

    int[] nums = {};

    int expected = 0;

    Assertions.assertEquals(expected, theMasseuseLcci.massage(nums));
  }
}
