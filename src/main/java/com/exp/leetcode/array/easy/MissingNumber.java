package com.exp.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * <p>nums 中的所有数字都 独一无二
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/missing-number/
 *
 * @number 268
 * @date 2021/4/25 1:51 AM
 */
public class MissingNumber {
  public int missingNumber1(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 != nums[i + 1]) {
        return nums[i] + 1;
      }
    }

    return nums[nums.length - 1] == nums.length ? nums[0] - 1 : nums[nums.length - 1] + 1;
  }

  public int missingNumber2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= nums.length; i++) {
      map.put(i, i);
    }

    for (int num : nums) {
      map.remove(num);
    }
    return map.values().stream().findFirst().get();
  }

  public int missingNumber3(int[] nums) {
    final int sum = nums.length * (nums.length + 1) / 2;

    int numsSum = 0;
    for (int num : nums) {
      numsSum += num;
    }
    return sum - numsSum;
  }
}
