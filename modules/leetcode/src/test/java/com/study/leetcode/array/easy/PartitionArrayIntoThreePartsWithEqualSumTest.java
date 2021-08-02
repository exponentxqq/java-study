package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartitionArrayIntoThreePartsWithEqualSumTest {
  @Test
  void test1() {
    final PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum =
        new PartitionArrayIntoThreePartsWithEqualSum();

    int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};

    boolean expected = true;

    Assertions.assertEquals(
        expected, partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(arr));
  }

  @Test
  void test2() {
    final PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum =
        new PartitionArrayIntoThreePartsWithEqualSum();

    int[] arr = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};

    boolean expected = false;

    Assertions.assertEquals(
        expected, partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(arr));
  }

  @Test
  void test3() {
    final PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum =
        new PartitionArrayIntoThreePartsWithEqualSum();

    int[] arr = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};

    boolean expected = true;

    Assertions.assertEquals(
        expected, partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(arr));
  }

  @Test
  void test4() {
    final PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum =
        new PartitionArrayIntoThreePartsWithEqualSum();

    int[] arr = {18, 12, -18, 18, -19, -1, 10, 10};

    boolean expected = true;

    Assertions.assertEquals(
        expected, partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(arr));
  }

  @Test
  void test5() {
    final PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum =
        new PartitionArrayIntoThreePartsWithEqualSum();

    int[] arr = {1, -1, 1, -1};

    boolean expected = false;

    Assertions.assertEquals(
        expected, partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(arr));
  }
}
