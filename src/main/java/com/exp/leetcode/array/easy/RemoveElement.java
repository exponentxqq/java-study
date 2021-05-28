package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * <p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-element
 *
 * @number 27
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int newIdx = 0;
    int point = 0;
    while (point < nums.length) {
      if (nums[point] != val) {
        nums[newIdx] = nums[point];
        newIdx++;
      }
      point++;
    }
    System.out.println(Arrays.toString(nums));
    return newIdx;
  }
}
