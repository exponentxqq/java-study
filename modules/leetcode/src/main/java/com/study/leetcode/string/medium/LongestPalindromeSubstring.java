package com.study.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * <p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @number 5
 * @date 2024/1/25 10:08
 */
public class LongestPalindromeSubstring {

  /**
   * 动态规划
   *
   * <p>P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串
   */
  public String longestPalindrome2(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    if (s.length() == 1) {
      return s;
    }

    return "";
  }

  /** 穷举 */
  public String longestPalindrome1(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    if (s.length() == 1) {
      return s;
    }

    List<String> subs = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length() - 1; j > i; j--) {
        int l = i;
        int r = j;
        boolean found = true;
        while (l < r) {
          if (s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
          } else {
            found = false;
            break;
          }
        }
        if (found) {
          subs.add(s.substring(i, j + 1));
        }
      }
    }

    if (subs.isEmpty()) {
      return s.substring(0, 1);
    }
    String maxSub = subs.get(0);
    for (String sub : subs) {
      if (maxSub.length() < sub.length()) {
        maxSub = sub;
      }
    }
    return maxSub;
  }
}
