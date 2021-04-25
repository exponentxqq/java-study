package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给定长度为 2n 的整数数组 nums
 *
 * <p>你的任务是将这些数分成 n 对,
 *
 * <p>例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai,bi)总和最大。
 *
 * <p>返回该 最大总和 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/array-partition-i
 *
 * @number 561
 */
public class ArrayPartition {
  /*越小的数就和越小的分在一起，可以尽量减少大数的损失*/
  public int arrayPairSum(int[] nums) {
    int n = nums.length / 2;
    Arrays.sort(nums);

    int max = nums[0];
    for (int i = 1; i < n; i++) {
      max += nums[2 * i];
    }

    return max;
  }
}
