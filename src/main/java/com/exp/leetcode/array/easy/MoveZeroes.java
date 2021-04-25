package com.exp.leetcode.array.easy;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/move-zeroes/
 *
 * @number 283
 * @date 2021/4/25 11:01 AM
 */
public class MoveZeroes {
  public void moveZeroes1(int[] nums) {
    int lastIdx = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 0) {
        for (int j = i; j < lastIdx; j++) {
          nums[j] = nums[j + 1];
          nums[j + 1] = 0;
        }
        lastIdx--;
      }
    }
  }

  public void moveZeroes2(int[] nums) {
    int startIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[startIdx] = nums[i];
        startIdx++;
      }
    }

    for (int i = nums.length - 1; i >= startIdx; i--) {
      nums[i] = 0;
    }
  }
}
