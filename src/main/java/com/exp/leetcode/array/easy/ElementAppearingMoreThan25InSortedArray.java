package com.exp.leetcode.array.easy;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * <p>请你找到并返回这个整数
 *
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * @incomplete
 * @number 1287
 * @date 2021/5/21 5:16 PM
 */
public class ElementAppearingMoreThan25InSortedArray {
  public int findSpecialInteger(int[] arr) {
    if (arr.length < 3) {
      return arr[0];
    }

    int gap = (int) Math.ceil((arr.length + 1) / 4D);

    for (int i = 0; i < arr.length; i += gap) {
      int end = Math.min(i + gap - 1, arr.length - 1);
      if (i != end && arr[i] == arr[end]) {
        return arr[i];
      } else if (i == end && arr[i] == arr[end + 1]) {
        return arr[i];
      }
    }
    return -1;
  }
}
