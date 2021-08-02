package com.study.leetcode.string.easy;

/**
 * 实现 strStr() 函数。
 *
 * <p>给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * <p>说明：
 *
 * <p>当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * <p>对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 * @number 28
 * @date 2021/6/9 14:34
 */
public class ImplementStrstr {
  // Knuth-Morris-Pratt 算法
  public int strStr(String haystack, String needle) {
    int n = haystack.length(), m = needle.length();
    if (m == 0) {
      return 0;
    }
    int[] pi = new int[m];
    for (int i = 1, j = 0; i < m; i++) {
      while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
        j = pi[j - 1];
      }
      if (needle.charAt(i) == needle.charAt(j)) {
        j++;
      }
      pi[i] = j;
    }
    for (int i = 0, j = 0; i < n; i++) {
      while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
        j = pi[j - 1];
      }
      if (haystack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      if (j == m) {
        return i - m + 1;
      }
    }
    return -1;
  }

  // 暴力求解2
  public int strStr2(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    int p = 0;
    int s = 0;
    while (p < haystack.length()) {
      if (p + s >= haystack.length()) {
        return -1;
      }
      if (haystack.charAt(p + s) != needle.charAt(s)) {
        p++;
        s = 0;
      } else {
        s++;
        if (s == needle.length()) {
          return p;
        }
      }
    }
    return -1;
  }

  // 暴力求解
  public int strStr1(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    int i = 0;
    boolean end = true;
    for (; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (i + j >= haystack.length()) {
          end = false;
          break;
        }
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          end = false;
          break;
        } else {
          end = true;
        }
      }
      if (end) {
        break;
      }
    }
    return end && haystack.length() > 0 ? i : -1;
  }
}
