package com.study.leetcode.array.easy;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * <p>如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 <br>
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * <p>当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/monotonic-array
 *
 * @number 896
 * @date 2021/5/12 5:07 PM
 */
public class MonotonicArray {
  public boolean isMonotonic(int[] nums) {
    boolean isAsc = nums[0] < nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      if (isAsc) {
        if (nums[i] < nums[i - 1]) {
          return false;
        }
      } else {
        if (nums[i] > nums[i - 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
