package com.exp.leetcode.array.easy;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * <p>你可以返回满足此条件的任何数组作为答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-array-by-parity/
 *
 * @number 905
 * @date 2021/5/13 9:51 AM
 */
public class SortArrayByParity {
  public int[] sortArrayByParity(int[] nums) {
    int[] res = new int[nums.length];

    int point = 0;
    int left = 0;
    int right = nums.length - 1;
    while (point < nums.length) {
      if (nums[point] % 2 == 0) {
        res[left] = nums[point];
        left++;
      } else {
        res[right] = nums[point];
        right--;
      }
      point++;
    }
    return res;
  }
}
