package com.exp.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * <p>如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @number 217
 * @date 2021/4/25 1:16 AM
 */
public class ContainsDuplicate {
  public boolean containsDuplicate1(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean containsDuplicate2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      if (map.containsKey(num)) {
        return true;
      } else {
        map.put(num, 1);
      }
    }
    return false;
  }
}
