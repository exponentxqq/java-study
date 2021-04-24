package com.exp.leetcode.array.easy;

import com.exp.util.Mocker;
import com.exp.util.Statistics;
import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @number 26
 */
public class RemoveDuplicatesFromSortedArray {
  private void remove(int[] nums, int key) {
    for (int i = key; i < nums.length; i++) {
      if (i == nums.length - 1) {
        nums[i] = 0;
      } else {
        nums[i] = nums[i + 1];
      }
    }
  }

  public int removeDuplicates1(int[] nums) {
    int i = 0;
    int length = nums.length;
    while (i < length - 1) {
      if (nums[i] == nums[i + 1]) {
        remove(nums, i + 1);
        length--;
      } else {
        i++;
      }
    }
    System.out.println(length);
    System.out.println(Arrays.toString(nums));
    return length;
  }

  public int removeDuplicates2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int newIdx = 0;
    int point = 1;

    while (point < nums.length) {
      if (nums[point] != nums[point - 1]) {
        newIdx++;
        nums[newIdx] = nums[point];
      }
      point++;
    }
    System.out.println(newIdx + 1);
    System.out.println(Arrays.toString(nums));
    return newIdx + 1;
  }
}
