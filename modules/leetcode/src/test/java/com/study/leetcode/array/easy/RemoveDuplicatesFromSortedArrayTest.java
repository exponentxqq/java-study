package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 3:37 PM */
public class RemoveDuplicatesFromSortedArrayTest {
  @Test
  void test1() {
    RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray =
        new RemoveDuplicatesFromSortedArray();

    int[] nums1 = {1, 2, 2, 5, 6, 9};
    int[] nums2 = {1, 2, 2, 5, 6, 9};

    int expect = 5;
    int[] expectNums = {1, 2, 5, 6, 9};

    assertResult(
        expect, removeDuplicatesFromSortedArray.removeDuplicates1(nums1), expectNums, nums1);
    assertResult(
        expect, removeDuplicatesFromSortedArray.removeDuplicates2(nums2), expectNums, nums2);
  }

  @Test
  void test2() {
    RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray =
        new RemoveDuplicatesFromSortedArray();

    int[] nums1 = {1, 1, 2, 5, 6, 6};
    int[] nums2 = {1, 1, 2, 5, 6, 6};

    int expect = 4;
    int[] expectNums = {1, 2, 5, 6};

    assertResult(
        expect, removeDuplicatesFromSortedArray.removeDuplicates1(nums1), expectNums, nums1);
    assertResult(
        expect, removeDuplicatesFromSortedArray.removeDuplicates2(nums2), expectNums, nums2);
  }

  private void assertResult(int expectLength, int resultLength, int[] expectNums, int[] inputNums) {
    Assertions.assertEquals(expectLength, resultLength);
    for (int i = 0; i < expectLength; i++) {
      Assertions.assertEquals(expectNums[i], inputNums[i]);
    }
  }
}
