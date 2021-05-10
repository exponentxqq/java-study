package com.exp.leetcode.array.easy;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 *
 * <p>数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * <p>如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 *
 * <p>注意：中心下标可能出现在数组的两端。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-pivot-index
 *
 * @number 724
 * @date 2021/5/10 4:09 PM
 */
public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int rightSum = 0;

    for (int i = 0; i < nums.length; i++) {
      rightSum += nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      if (leftSum == rightSum - nums[i]) {
        return i;
      } else {
        leftSum += nums[i];
        rightSum -= nums[i];
      }
    }
    return -1;
  }
}
