package com.exp.leetcode.array.easy;

import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * <p>请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *
 * <p>注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/height-checker
 *
 * @number 1051
 * @date 2021/5/21 1:29 PM
 */
public class HeightChecker {
  public int heightChecker(int[] heights) {
    int[] tmp = new int[heights.length];
    System.arraycopy(heights, 0, tmp, 0, heights.length);
    Arrays.sort(tmp);

    int count = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != tmp[i]) {
        count++;
      }
    }
    return count;
  }
}
