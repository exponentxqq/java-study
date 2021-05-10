package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DegreeOfAnArrayTest {
  @Test
  void test1() {
    final DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

    int[] nums = {1, 2, 2, 3, 1};

    int expect = 2;

    Assertions.assertEquals(expect, degreeOfAnArray.findShortestSubArray(nums));
  }

  @Test
  void test2() {
    final DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

    int[] nums = {1, 2, 2, 3, 1, 4, 2};

    int expect = 6;

    Assertions.assertEquals(expect, degreeOfAnArray.findShortestSubArray(nums));
  }

  @Test
  void test3() {
    final DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

    int[] nums = {1};

    int expect = 1;

    Assertions.assertEquals(expect, degreeOfAnArray.findShortestSubArray(nums));
  }

  @Test
  void test4() {
    final DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

    int[] nums = {1, 1};

    int expect = 2;

    Assertions.assertEquals(expect, degreeOfAnArray.findShortestSubArray(nums));
  }

  @Test
  void test5() {
    final DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

    int[] nums = {};

    int expect = 0;

    Assertions.assertEquals(expect, degreeOfAnArray.findShortestSubArray(nums));
  }
}
