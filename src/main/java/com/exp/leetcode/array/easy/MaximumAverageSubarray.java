package com.exp.leetcode.array.easy;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i/
 *
 * @number 643
 * @date 2021/4/25 7:22 PM
 */
public class MaximumAverageSubarray {
  public double findMaxAverage1(int[] nums, int k) {
    double[] sums = new double[nums.length - k + 1];

    for (int i = 0; i <= nums.length - k; i++) {
      for (int j = i; j < i + k; j++) {
        sums[i] += nums[j];
      }
    }

    double max = sums[0] / k;
    for (int i = 1; i < sums.length; i++) {
      max = Math.max(max, sums[i] / k);
    }

    return max;
  }

  public double findMaxAverage(int[] nums, int k) {

    return 1.0;
  }
}
