package com.study.leetcode.array.easy;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * @number 485
 * @date 2021/4/25 3:18 PM
 */
public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        ++count;
      } else {
        max = Math.max(max, count);
        count = 0;
      }
    }
    return Math.max(max, count);
  }
}
