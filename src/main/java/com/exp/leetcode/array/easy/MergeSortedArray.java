package com.exp.leetcode.array.easy;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * <p>初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @nubmer 88
 * @date 2021/4/24 4:00 PM
 */
public class MergeSortedArray {
  /** nums1的长度足以保存nums2的数据，因此nums1的后半段的空间是空的，可以直接插入item而不用考虑其他item的挪动 */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int newIdx = m + n - 1;
    int point1 = m - 1;
    int point2 = n - 1;

    while (point1 >= 0 && point2 >= 0) {
      if (nums1[point1] > nums2[point2]) {
        nums1[newIdx] = nums1[point1];
        point1--;
      } else {
        nums1[newIdx] = nums2[point2];
        point2--;
      }
      newIdx--;
    }

    if (point2 >= 0) {
      for (int i = 0; i <= point2; i++) {
        nums1[i] = nums2[i];
      }
    }
  }
}
