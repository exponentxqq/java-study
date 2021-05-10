package com.exp.leetcode.array.easy;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * <p>连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，<br>
 * 如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1],
 * nums[r]] 就是连续递增子序列。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 *
 * @number 674
 * @date 2021/5/10 1:22 PM
 */
public class LongestContinuousIncreasingSubsequence {
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int max = 1;
    int current = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        current++;
        max = Math.max(current, max);
      } else {
        current = 1;
      }
    }

    return max;
  }
}
