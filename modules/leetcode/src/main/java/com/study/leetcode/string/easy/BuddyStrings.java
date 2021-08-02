package com.study.leetcode.string.easy;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * <p>交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成
 * "cbad" 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/buddy-strings
 *
 * @number 859
 * @date 2021/6/15 18:38
 */
public class BuddyStrings {
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) return false;
    if (s.equals(goal)) {
      int[] count = new int[26];
      for (int i = 0; i < s.length(); ++i) {
        count[s.charAt(i) - 'a']++;
      }

      for (int c : count) {
        if (c > 1) return true;
      }
      return false;
    } else {
      int first = -1, second = -1;
      for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) != goal.charAt(i)) {
          if (first == -1) {
            first = i;
          } else if (second == -1) {
            second = i;
          } else {
            return false;
          }
        }
      }

      return (second != -1
          && s.charAt(first) == goal.charAt(second)
          && s.charAt(second) == goal.charAt(first));
    }
  }
}
