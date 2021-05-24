package com.exp.leetcode.array.easy;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，<br>
 * 如果是最后一个元素，用 -1 替换。
 *
 * <p>完成所有替换操作后，请你返回这个数组。
 *
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * @number 1299
 * @date 2021/5/22 4:26 PM
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
  public int[] replaceElements(int[] arr) {
    if (arr.length < 2) {
      arr[0] = -1;
      return arr;
    }
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length - 1) {
        result[i] = -1;
      } else {
        int max = arr[i + 1];
        for (int j = i + 2; j < arr.length; j++) {
          max = Math.max(max, arr[j]);
        }
        result[i] = max;
      }
    }
    return result;
  }

}
