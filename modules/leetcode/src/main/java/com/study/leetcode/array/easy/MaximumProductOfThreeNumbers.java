package com.study.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * <p>整型包含负数
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 *
 * @number 628
 * @date 2021/4/25 7:06 PM
 */
public class MaximumProductOfThreeNumbers {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int l = nums.length;
    return Math.max(nums[l - 1] * nums[l - 2] * nums[l - 3], nums[0] * nums[1] * nums[l - 1]);
  }
}
