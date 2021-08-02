package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPivotIndexTest {
  @Test
  void test1() {
    final FindPivotIndex findPivotIndex = new FindPivotIndex();

    int[] nums = {1, 7, 3, 6, 5, 6};

    int expect = 3;

    Assertions.assertEquals(expect, findPivotIndex.pivotIndex(nums));
  }

  @Test
  void test2() {
    final FindPivotIndex findPivotIndex = new FindPivotIndex();

    int[] nums = {1, 2, 3};

    int expect = -1;

    Assertions.assertEquals(expect, findPivotIndex.pivotIndex(nums));
  }

  @Test
  void test3() {
    final FindPivotIndex findPivotIndex = new FindPivotIndex();

    int[] nums = {2, 1, -1};

    int expect = 0;

    Assertions.assertEquals(expect, findPivotIndex.pivotIndex(nums));
  }

  @Test
  void test4() {
    final FindPivotIndex findPivotIndex = new FindPivotIndex();

    int[] nums = {1, -1, 2};

    int expect = 2;

    Assertions.assertEquals(expect, findPivotIndex.pivotIndex(nums));
  }
}
