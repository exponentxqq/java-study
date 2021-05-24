package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/25 12:00 AM */
public class ThreeConsecutiveOddsTest {
  @Test
  void test1() {
    ThreeConsecutiveOdds threeConsecutiveOdds = new ThreeConsecutiveOdds();

    int[] arr = {2, 6, 4, 1};

    boolean expected = false;

    Assertions.assertEquals(expected, threeConsecutiveOdds.threeConsecutiveOdds(arr));
  }

  @Test
  void test2() {
    ThreeConsecutiveOdds threeConsecutiveOdds = new ThreeConsecutiveOdds();

    int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};

    boolean expected = true;

    Assertions.assertEquals(expected, threeConsecutiveOdds.threeConsecutiveOdds(arr));
  }
}
