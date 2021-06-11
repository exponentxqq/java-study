package com.exp.leetcode.string.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * <p>如果不存在公共前缀，返回空字符串 ""。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @number 14
 * @date 2021/5/26 8:55 PM
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    String pre = "";

    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
          return pre;
        }
      }
      pre += c;
    }

    return pre;
  }
}
