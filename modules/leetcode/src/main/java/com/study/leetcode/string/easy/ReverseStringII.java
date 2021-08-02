package com.study.leetcode.string.easy;

/**
 * 给定一个字符串 s 和一个整数k。<br>
 * 你需要对从字符串开头算起的每隔2k个字符的前 k 个字符进行反转。
 *
 * <p>如果剩余字符少于 k 个，则将剩余字符全部反转。 <br>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符<br>
 * 其余字符保持原样。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-string-ii
 *
 * @number 541
 * @date 2021/6/10 10:52
 */
public class ReverseStringII {
  public String reverseStr(String s, int k) {
    String result = "";
    final int count = (int) Math.ceil(s.length() / (double) k);
    int limit = count % 2 == 0 ? count * (k + 1) : count * k;

    int i = 2 * k;
    do {
      String tmp = "";
      for (int j = Math.max(i - 2 * k, 0); j < Math.min(i - k, s.length()); j++) {
        tmp = s.charAt(j) + tmp;
      }
      result += tmp;

      if (i - 2 * k >= 0) {
        for (int j = Math.max(i - k, 0); j < Math.min(i, s.length()); j++) {
          result += s.charAt(j);
        }
      }
      i += (2 * k);
    } while (i <= limit);

    if (result.length() != s.length()) {
      if (count % 2 == 0) {
        result += s.substring(result.length());
      } else {
        int len = result.length();
        for (int j = s.length() - 1; j >= len; j--) {
          result += s.charAt(j);
        }
      }
    }

    return result;
  }
}
