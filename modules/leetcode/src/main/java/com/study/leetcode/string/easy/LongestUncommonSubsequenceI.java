package com.study.leetcode.string.easy;

/**
 * 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
 *
 * <p>「最长特殊序列」定义如下：<br>
 * 该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * <p>子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。<br>
 * 空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * <p>输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
 *
 * @number 521
 * @date 2021/6/10 10:19
 */
public class LongestUncommonSubsequenceI {
  public int findLUSlength(String a, String b) {
    if (a.equals(b)) return -1;
    return Math.max(a.length(), b.length());
  }
}
