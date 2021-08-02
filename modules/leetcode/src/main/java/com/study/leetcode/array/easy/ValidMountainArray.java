package com.study.leetcode.array.easy;

/**
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * <p>让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * <p>arr.length >= 3 在 0 < i < arr.length - 1 条件下，存在 i 使得：<br>
 * arr[0] < arr[1] < ... arr[i-1] < arr[i] <br>
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-mountain-array
 *
 * @number 941
 * @date 2021/5/20 2:24 PM
 */
public class ValidMountainArray {
  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }

    int maxNumIdx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[maxNumIdx] <= arr[i]) {
        maxNumIdx = i;
      }
    }

    if (maxNumIdx == 0 || maxNumIdx == arr.length - 1) {
      return false;
    }

    for (int i = 0; i < maxNumIdx; i++) {
      if (arr[i] >= arr[i + 1]) {
        return false;
      }
    }

    for (int i = maxNumIdx + 1; i < arr.length; i++) {
      if (arr[i - 1] <= arr[i]) {
        return false;
      }
    }
    return true;
  }
}
