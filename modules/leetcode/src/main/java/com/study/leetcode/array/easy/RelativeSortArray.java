package com.study.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * <p>arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中
 *
 * <p>对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/relative-sort-array
 *
 * @number 1122
 * @date 2021/5/21 3:09 PM
 */
public class RelativeSortArray {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> arr1Map = new HashMap<>();

    for (int j : arr1) {
      if (arr1Map.containsKey(j)) {
        arr1Map.put(j, arr1Map.get(j) + 1);
      } else {
        arr1Map.put(j, 1);
      }
    }

    int[] result = new int[arr1.length];
    final AtomicInteger resultPoint = new AtomicInteger();

    for (int k : arr2) {
      for (int j = 0; j < arr1Map.get(k); j++) {
        result[resultPoint.get()] = k;
        resultPoint.incrementAndGet();
      }
      arr1Map.remove(k);
    }

    arr1Map.keySet().stream()
        .sorted()
        .forEach(
            i -> {
              for (int j = 0; j < arr1Map.get(i); j++) {
                result[resultPoint.get()] = i;
                resultPoint.incrementAndGet();
              }
            });

    return result;
  }
}
