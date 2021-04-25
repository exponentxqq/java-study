package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/25 1:52 AM */
public class MissingNumberTest {
  @Test
  void test1() {
    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {3, 0, 1};

    int expect = 2;

    Assertions.assertEquals(expect, missingNumber.missingNumber3(nums));
  }

  @Test
  void test2() {
    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {0, 1};

    int expect = 2;

    Assertions.assertEquals(expect, missingNumber.missingNumber3(nums));
  }

  @Test
  void test3() {
    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

    int expect = 8;

    Assertions.assertEquals(expect, missingNumber.missingNumber3(nums));
  }

  @Test
  void test4() {
    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {1};

    int expect = 0;

    Assertions.assertEquals(expect, missingNumber.missingNumber3(nums));
  }

  @Test
  void test5() {
    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {1, 2};

    int expect = 0;

    Assertions.assertEquals(expect, missingNumber.missingNumber3(nums));
  }
}
