package com.exp.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * <p>请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-absolute-difference/
 *
 * @number 1200
 * @date 2021/5/25 12:07 AM
 */
public class MinimumAbsoluteDifference {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();

    int min = arr[1] - arr[0];
    for (int i = 1; i < arr.length - 1; i++) {
      min = Math.min(min, arr[i + 1] - arr[i]);
    }

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] == min) {
        result.add(List.of(arr[i], arr[i + 1]));
      }
    }

    return result;
  }
}
