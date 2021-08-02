package com.study.leetcode.dynamicprogramming.easy;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。<br>
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。<br>
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 *
 * @number interview 17.16
 * @date @date 2021/6/9 10:23
 */
public class TheMasseuseLcci {
  public int massage(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[1], nums[0]);
    }
    int[] f = new int[nums.length];
    f[0] = nums[0];
    f[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      f[i] = Math.max(f[i - 1] - nums[i - 1] + nums[i], f[i - 2] + nums[i]);
      f[i] = Math.max(f[i - 1], f[i]);
    }
    return f[f.length - 1];
  }
}
