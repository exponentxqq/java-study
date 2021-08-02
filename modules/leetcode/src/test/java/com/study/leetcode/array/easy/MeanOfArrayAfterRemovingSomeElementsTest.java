package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeanOfArrayAfterRemovingSomeElementsTest {
  @Test
  void test1() {
    final MeanOfArrayAfterRemovingSomeElements meanOfArrayAfterRemovingSomeElements =
        new MeanOfArrayAfterRemovingSomeElements();

    int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};

    double expected = 2.0;

    Assertions.assertEquals(expected, meanOfArrayAfterRemovingSomeElements.trimMean(arr));
  }

  @Test
  void test2() {
    final MeanOfArrayAfterRemovingSomeElements meanOfArrayAfterRemovingSomeElements =
        new MeanOfArrayAfterRemovingSomeElements();

    int[] arr = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};

    double expected = 4.0;

    Assertions.assertEquals(expected, meanOfArrayAfterRemovingSomeElements.trimMean(arr));
  }

  @Test
  void test3() {
    final MeanOfArrayAfterRemovingSomeElements meanOfArrayAfterRemovingSomeElements =
        new MeanOfArrayAfterRemovingSomeElements();

    int[] arr = {
      6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6,
      6, 1, 0, 6, 10, 8, 2, 3, 4
    };

    double expected = 4.77778;

    final double actual = meanOfArrayAfterRemovingSomeElements.trimMean(arr);
    Assertions.assertTrue(actual >= expected - Math.pow(10, -5));
    Assertions.assertTrue(actual <= expected + Math.pow(10, -5));
  }
}
