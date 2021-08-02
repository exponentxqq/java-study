package com.study.leetcode.array.easy;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * <p>请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 *
 * @number 747
 * @date 2021/5/10 4:48 PM
 */
public class LargestNumberAtLeastTwiceOfOthers {
  public int dominantIndex(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return 0;
    }
    int maxIdx = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[maxIdx] < nums[i]) {
        maxIdx = i;
      }
    }

    boolean isDominant = true;
    for (int i = 0; i < nums.length; i++) {
      if (i == maxIdx) {
        continue;
      }
      if (nums[i] == 0) {
        continue;
      }
      if (nums[maxIdx] / nums[i] >= 2) {
        continue;
      }
      isDominant = false;
      break;
    }
    return isDominant ? maxIdx : -1;
  }
}
