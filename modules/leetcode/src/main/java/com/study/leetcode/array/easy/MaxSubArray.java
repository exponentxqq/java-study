package com.study.leetcode.array.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @number 53
 * @date 2021/4/22 10:53 PM
 */
public class MaxSubArray {
  /** 暴力求解 */
  public int maxSubArray1(final int[] nums) {
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (max <= sum) {
          max = sum;
        }
      }
    }
    return max;
  }

  /**
   * 动态规划
   *
   * <p>假设i位置的最大子数组之和为f[i]
   *
   * <p>则f[i]=max(f[i - 1] + sum[i], sum[i])
   */
  public int maxSubArray2(final int[] nums) {
    int[] f = new int[nums.length];
    f[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
      max = Math.max(max, f[i]);
    }
    return max;
  }
}
