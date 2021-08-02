package com.study.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。<br>
 * 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * <p>给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 *
 * @number 989
 * @date 2021/5/20 4:11 PM
 */
public class AddToArrayFormOfInteger {
  public List<Integer> addToArrayForm(int[] num, int k) {
    final String[] split = String.valueOf(k).split("");

    final ArrayList<Integer> result = new ArrayList<>();

    int a = num.length - 1;
    int b = split.length - 1;

    int tmp = 0;
    while (a >= 0 || b >= 0) {
      int cur = 0;
      if (a >= 0 && b >= 0) {
        cur = Integer.parseInt(split[b]) + num[a] + tmp;
      } else if (a >= 0 && b < 0) {
        cur = num[a] + tmp;
      } else {
        cur = Integer.parseInt(split[b]) + tmp;
      }
      if (cur > 9) {
        result.add(cur - 10);
        tmp = 1;
      } else {
        result.add(cur);
        tmp = 0;
      }
      a--;
      b--;
    }
    if (tmp == 1) {
      result.add(tmp);
    }
    Collections.reverse(result);
    return result;
  }
}
