package com.exp.leetcode.string.easy;

/**
 * 给定一个字符串s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 *
 * <p>重复出现的子串要计算它们出现的次数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-binary-substrings
 *
 * @number 696
 * @date 2021/6/12 15:28
 */
public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
    int oneCount = 0;
    int zeroCount = 0;
    int result = 0;

    boolean startZero = s.charAt(0) == '0';
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '1') {
        oneCount++;
        if (startZero) {
          if (i + 1 >= s.length() || s.charAt(i + 1) == '0') {
            result += Math.min(oneCount, zeroCount);
            zeroCount = 0;
            startZero = false;
          }
        }
      } else {
        zeroCount++;
        if (!startZero) {
          if (i + 1 >= s.length() || s.charAt(i + 1) == '1') {
            result += Math.min(zeroCount, oneCount);
            oneCount = 0;
            startZero = true;
          }
        }
      }
    }

    return result;
  }
}
