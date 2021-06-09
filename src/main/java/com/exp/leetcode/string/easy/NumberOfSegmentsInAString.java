package com.exp.leetcode.string.easy;

import java.util.Arrays;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * <p>请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 *
 * @number 434
 * @date 2021/6/9 19:07
 */
public class NumberOfSegmentsInAString {
  public int countSegments(String s) {
    if (s.length() == 0) {
      return 0;
    }
    final String[] s1 = s.split(" ");
    return (int) Arrays.stream(s1).filter(item -> item.length() > 0).count();
  }
}
