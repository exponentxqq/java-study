package com.exp.leetcode.dynamicprogramming.easy;

import com.exp.leetcode.array.easy.MaxSubArray;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * <p>要求时间复杂度为O(n)。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @see MaxSubArray
 * @number offer 42
 * @date @date 2021/6/9 13:06
 */
public class MaxSumSubArray {
  /** f[i] = max(f[i - 1] + nums[i], nums[i]) */
  public int maxSubArray(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
    }

    int max = result[0];
    for (int i = 1; i < result.length; i++) {
      max = Math.max(result[i], max);
    }
    return max;
  }
}
