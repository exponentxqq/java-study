package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidMountainArrayTest {
  @Test
  void test1() {
    final ValidMountainArray validMountainArray = new ValidMountainArray();

    int[] nums = {2, 1};

    boolean expected = false;

    Assertions.assertEquals(expected, validMountainArray.validMountainArray(nums));
  }

  @Test
  void test2() {
    final ValidMountainArray validMountainArray = new ValidMountainArray();

    int[] nums = {3, 5, 5};

    boolean expected = false;

    Assertions.assertEquals(expected, validMountainArray.validMountainArray(nums));
  }

  @Test
  void test3() {
    final ValidMountainArray validMountainArray = new ValidMountainArray();

    int[] nums = {0, 3, 2, 1};

    boolean expected = true;

    Assertions.assertEquals(expected, validMountainArray.validMountainArray(nums));
  }

  @Test
  void test4() {
    final ValidMountainArray validMountainArray = new ValidMountainArray();

    int[] nums = {1, 2, 3, 2, 1};

    boolean expected = true;

    Assertions.assertEquals(expected, validMountainArray.validMountainArray(nums));
  }

  @Test
  void test5() {
    final ValidMountainArray validMountainArray = new ValidMountainArray();

    int[] nums = {2, 1, 3, 2, 1};

    boolean expected = false;

    Assertions.assertEquals(expected, validMountainArray.validMountainArray(nums));
  }
}
