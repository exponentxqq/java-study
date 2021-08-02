package com.study.leetcode.array.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * <p>你可以假设数组中无重复元素。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-insert-position/
 *
 * @number 35
 */
public class SearchInsert {
  public int searchInsert1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }
}
