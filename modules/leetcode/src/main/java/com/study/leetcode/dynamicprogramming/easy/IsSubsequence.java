package com.study.leetcode.dynamicprogramming.easy;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * <p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。<br>
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * <p>进阶：
 *
 * <p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。<br>
 * 在这种情况下，你会怎样改变代码？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/is-subsequence
 *
 * @number 338
 * @date @date 2021/6/4 14:54
 */
public class IsSubsequence {
  /**
   * 动态规划
   *
   * @imcomplete
   */
  public boolean isSubsequence(String s, String t) {
    return false;
  }

  /** 暴力求解 */
  public boolean isSubsequence1(String s, String t) {
    int pre = -1;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      boolean found = false;
      for (int j = start; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          found = true;
          if (j > pre) {
            pre = j;
            start = j + 1;
            break;
          } else {
            return false;
          }
        }
      }
      if (!found) {
        return false;
      }
    }
    return true;
  }
}
