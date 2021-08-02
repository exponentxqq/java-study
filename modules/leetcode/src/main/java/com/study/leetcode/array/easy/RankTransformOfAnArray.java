package com.study.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * <p>序号代表了一个元素有多大。序号编号的规则如下：
 *
 * <p>序号从 1 开始编号。 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。 每个数字的序号都应该尽可能地小。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
 *
 * @number 1331
 * @date 2021/5/22 11:00 PM
 */
public class RankTransformOfAnArray {
  public int[] arrayRankTransform(int[] arr) {
    int[] temp = Arrays.copyOf(arr, arr.length);
    Arrays.sort(temp);
    Map<Integer, Integer> sortedMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (!sortedMap.containsKey(temp[i])) {
        sortedMap.put(temp[i], sortedMap.size() + 1);
      }
    }

    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      result[i] = sortedMap.get(arr[i]);
    }

    return result;
  }
}
