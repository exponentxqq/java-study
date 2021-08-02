package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 3:30 PM */
public class PlusOneTest {
  @Test
  void test1() {
    PlusOne plusOne = new PlusOne();

    int[] digits = {0};
    int[] expect = {1};

    Assertions.assertArrayEquals(expect, plusOne.plusOne(digits));
  }

  @Test
  void test2() {
    PlusOne plusOne = new PlusOne();

    int[] digits = {9};
    int[] expect = {1, 0};

    Assertions.assertArrayEquals(expect, plusOne.plusOne(digits));
  }

  @Test
  void test3() {
    PlusOne plusOne = new PlusOne();

    int[] digits = {1, 1, 9};
    int[] expect = {1, 2, 0};

    Assertions.assertArrayEquals(expect, plusOne.plusOne(digits));
  }

  @Test
  void test4() {
    PlusOne plusOne = new PlusOne();

    int[] digits = {9, 9, 9};
    int[] expect = {1, 0, 0, 0};

    Assertions.assertArrayEquals(expect, plusOne.plusOne(digits));
  }

  @Test
  void test5() {
    PlusOne plusOne = new PlusOne();

    int[] digits = {1, 2, 3};
    int[] expect = {1, 2, 4};

    Assertions.assertArrayEquals(expect, plusOne.plusOne(digits));
  }
}
