package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，<br>
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @number 977
 * @date 2021/5/20 2:15 PM
 */
public class SquaresOfASortedArray {
  public int[] sortedSquares1(int[] nums) {
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      result[i] = nums[i] * nums[i];
    }

    Arrays.sort(result);
    return result;
  }

  public int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];

    int left = 0;
    int right = nums.length - 1;
    int point = nums.length - 1;

    while (left <= right) {
      int leftResult = nums[left] * nums[left];
      int rightResult = nums[right] * nums[right];

      if (leftResult > rightResult) {
        result[point] = leftResult;
        left++;
      } else {
        result[point] = rightResult;
        right--;
      }
      point--;
    }
    return result;
  }
}
