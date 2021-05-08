package com.exp.leetcode.array.easy;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * <p>我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/non-decreasing-array
 *
 * @incomplete
 * @number 665
 * @date 2021/5/8 10:46 AM
 */
public class NonDecreasingArray {
  public boolean checkPossibility(int[] nums) {
    int changeTimes = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        nums[i] = nums[i - 1];
        changeTimes++;
        for (int j = i - 2; j >= 0; j--) {
          if (nums[j] > nums[i]) {
            return false;
          }
        }
      }
      if (changeTimes > 1) {
        return false;
      }
    }
    return true;
  }
}
