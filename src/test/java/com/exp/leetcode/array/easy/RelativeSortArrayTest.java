package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RelativeSortArrayTest {
  @Test
  void test1() {
    final RelativeSortArray relativeSortArray = new RelativeSortArray();

    int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = {2, 1, 4, 3, 9, 6};

    int[] expected = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};

    Assertions.assertArrayEquals(expected, relativeSortArray.relativeSortArray(arr1, arr2));
  }

  @Test
  void test2() {
    final RelativeSortArray relativeSortArray = new RelativeSortArray();

    int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
    int[] arr2 = {2, 42, 38, 0, 43, 21};

    int[] expected = {2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48};

    Assertions.assertArrayEquals(expected, relativeSortArray.relativeSortArray(arr1, arr2));
  }
}
