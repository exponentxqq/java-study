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
    int cur = arr[0];
    int count = 1;

    for (int i = 1; i < arr.length; i++) {
      if (cur == arr[i]) {
        count++;
        if (count * 4 > arr.length) {
          return cur;
        }
      } else {
        count = 1;
        cur = arr[i];
      }
    }
    return count * 4 > arr.length ? cur : -1;
  }
}
