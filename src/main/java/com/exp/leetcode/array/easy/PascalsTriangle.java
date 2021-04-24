package com.exp.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @number 118
 * @date 2021/4/24 4:33 PM
 */
public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> lists = new ArrayList<>(numRows);

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
        }
      }
      lists.add(row);
    }
    return lists;
  }
}
