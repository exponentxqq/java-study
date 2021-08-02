package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumProductOfThreeNumbersTest {
  @Test
  void test1() {
    final MaximumProductOfThreeNumbers maximumProductOfThreeNumbers =
        new MaximumProductOfThreeNumbers();

    int[] nums = {1, 2, 3};

    int expect = 6;

    Assertions.assertEquals(expect, maximumProductOfThreeNumbers.maximumProduct(nums));
  }

  @Test
  void test2() {
    final MaximumProductOfThreeNumbers maximumProductOfThreeNumbers =
        new MaximumProductOfThreeNumbers();

    int[] nums = {1, 2, 3, 4};

    int expect = 24;

    Assertions.assertEquals(expect, maximumProductOfThreeNumbers.maximumProduct(nums));
  }

  @Test
  void test3() {
    final MaximumProductOfThreeNumbers maximumProductOfThreeNumbers =
        new MaximumProductOfThreeNumbers();

    int[] nums = {-1, -2, -3};

    int expect = -6;

    Assertions.assertEquals(expect, maximumProductOfThreeNumbers.maximumProduct(nums));
  }

  @Test
  void test4() {
    final MaximumProductOfThreeNumbers maximumProductOfThreeNumbers =
        new MaximumProductOfThreeNumbers();

    int[] nums = {-100, -98, -1, 2, 3, 4};

    int expect = 39200;

    Assertions.assertEquals(expect, maximumProductOfThreeNumbers.maximumProduct(nums));
  }
}
