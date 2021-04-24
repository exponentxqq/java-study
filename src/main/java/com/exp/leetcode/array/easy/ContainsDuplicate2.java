package com.exp.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * @number 219
 * @date 2021/4/25 1:37 AM
 */
public class ContainsDuplicate2 {
  public boolean containsNearbyDuplicate1(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j] && j - i <= k) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}
