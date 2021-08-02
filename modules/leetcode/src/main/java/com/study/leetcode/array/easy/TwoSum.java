package com.study.leetcode.array.easy;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * <p>你可以按任意顺序返回答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @number 1
 */
public class TwoSum {
  // O(n^2)
  public int[] twoSum1(int[] nums, int target) {
    if (nums.length < 2) {
      return new int[0];
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }

    return new int[0];
  }

  // O(n)
  public int[] twoSum2(int[] nums, int target) {
    if (nums.length < 2) {
      return new int[0];
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (map.containsKey(temp)) {
        return new int[] {map.get(temp), i};
      }
      map.put(nums[i], i);
    }

    return new int[0];
  }
}
