package com.exp.leetcode.dynamicprogramming.easy;

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * <p>实现 RangeSumQueryImmutable 类：
 *
 * <p>RangeSumQueryImmutable(int[] nums) 使用数组 nums 初始化对象<br>
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，<br>
 * 包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 *
 * @number 303
 * @date @date 2021/6/4 14:44
 */
public class RangeSumQueryImmutable {
  private int[] nums;

  public RangeSumQueryImmutable(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int left, int right) {
    int sum = 0;
    for (int i = left; i <= right; i++) {
      sum += nums[i];
    }
    return sum;
  }
}
