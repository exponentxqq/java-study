package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * @number 119
 * @date 2021/4/24 4:43 PM
 */
public class PascalsTriangle2 {
  /**
   * 杨辉三角没行中每个元素的通项公式为：row[i - 1]*(rowIdx - i + 1) / i
   *
   * <p>即每一项都等于 前一项*(当前行数-当前项索引+1)/当前项索引
   */
  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>(rowIndex);
    row.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      row.add(row.get(i - 1) * (rowIndex - i + 1) / i);
    }
    return row;
  }
}
