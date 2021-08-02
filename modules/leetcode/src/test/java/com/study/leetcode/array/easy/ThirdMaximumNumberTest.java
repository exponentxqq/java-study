package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdMaximumNumberTest {
  @Test
  void test1() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {3, 2, 1};

    int expect = 1;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test2() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {2, 2, 3, 1};

    int expect = 1;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test3() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {2, 1};

    int expect = 2;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test4() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {5, 2, 2};

    int expect = 5;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test5() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {1, 2, 2, 5, 3, 5};

    int expect = 2;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test6() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {1, 2, -2147483648};

    int expect = -2147483648;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test7() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {1, -2147483648, 2};

    int expect = -2147483648;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }

  @Test
  void test8() {
    final ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

    int[] nums = {-2147483648, 1, 2};

    int expect = -2147483648;

    Assertions.assertEquals(expect, thirdMaximumNumber.thirdMax1(nums));
  }
}
