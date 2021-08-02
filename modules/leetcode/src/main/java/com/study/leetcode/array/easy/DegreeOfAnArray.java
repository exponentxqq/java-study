package com.study.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * <p>你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/degree-of-an-array
 *
 * @number 697
 * @date 2021/5/10 1:31 PM
 */
public class DegreeOfAnArray {
  public int findShortestSubArray(int[] nums) {
    // {num: [count, start, end]}
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        final int[] record = map.get(nums[i]);
        record[0] = record[0] + 1;
        record[2] = i;
        map.put(nums[i], record);
      } else {
        map.put(nums[i], new int[] {1, i, i});
      }
    }

    int degree = 0;
    for (int[] value : map.values()) {
      degree = Math.max(value[0], degree);
    }

    int min = nums.length;
    for (int[] value : map.values()) {
      if (value[0] == degree) {
        min = Math.min(min, value[2] - value[1] + 1);
      }
    }

    return min;
  }

  /** 暴力求解 */
  public int findShortestSubArray1(int[] nums) {
    int degree = calcDegree(nums, 0, nums.length);

    int min = nums.length;
    for (int i = 0; i < nums.length; i++) {
      for (int j = degree; j < nums.length; j++) {
        if (calcDegree(nums, i, j) == degree) {
          min = Math.min(min, j);
        }
      }
    }

    return min;
  }

  private int calcDegree(final int[] nums, int start, int length) {
    final Map<Integer, Integer> map = new HashMap<>();

    final int len = Math.min(length + start, nums.length);
    for (int i = start; i < len; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }

    int max = 0;
    for (Integer value : map.values()) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }
}
