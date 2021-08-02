package com.study.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * <p>函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数，<br>
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * <p>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 *
 * @number 167
 * @date 2021/4/24 11:35 PM
 */
public class TwoSum2 {
  public int[] twoSum1(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
      int temp = target - numbers[i];
      if (map.containsKey(numbers[i])) {
        return new int[] {map.get(numbers[i]) + 1, i + 1};
      }
      map.put(temp, i);
    }

    return new int[] {0, 0};
  }

  /** 双指针 */
  public int[] twoSum2(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    while (left <= numbers.length && right >= 0) {
      int temp = numbers[left] + numbers[right];
      if (temp == target) {
        return new int[] {left + 1, right + 1};
      } else if (temp > target) {
        right--;
      } else {
        left++;
      }
    }

    return new int[] {-1, -1};
  }
}
