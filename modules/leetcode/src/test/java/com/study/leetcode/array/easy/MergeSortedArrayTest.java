package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 4:01 PM */
public class MergeSortedArrayTest {
  @Test
  void test1() {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
    int m = 3;
    int[] nums2 = {4, 5, 6, 7};
    int n = 4;

    int[] expect = {1, 2, 3, 4, 5, 6, 7};

    mergeSortedArray.merge(nums1, m, nums2, n);
    Assertions.assertArrayEquals(expect, nums1);
  }

  @Test
  void test2() {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    int[] nums1 = {4, 5, 6, 0, 0, 0, 0};
    int m = 3;
    int[] nums2 = {1, 2, 3, 7};
    int n = 4;

    int[] expect = {1, 2, 3, 4, 5, 6, 7};

    mergeSortedArray.merge(nums1, m, nums2, n);
    Assertions.assertArrayEquals(expect, nums1);
  }

  @Test
  void test3() {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    int[] nums1 = {0};
    int m = 0;
    int[] nums2 = {1};
    int n = 1;

    int[] expect = {1};

    mergeSortedArray.merge(nums1, m, nums2, n);
    Assertions.assertArrayEquals(expect, nums1);
  }
}
