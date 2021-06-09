package com.exp.leetcode.string.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * <p>输入为 非空 字符串且只包含数字 1 和 0。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-binary/
 *
 * @number 67
 * @date 2021/6/9 15:52
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    int al = a.length();
    int bl = b.length();

    int ap = al - 1;
    int bp = bl - 1;

    boolean enter = false;
    String result = "";
    while (ap >= 0 || bp >= 0) {
      int cur = enter ? 1 : 0;
      if (ap >= 0) {
        if (a.charAt(ap) == '1') {
          cur += 1;
        }
        ap--;
      }
      if (bp >= 0) {
        if (b.charAt(bp) == '1') {
          cur += 1;
        }
        bp--;
      }

      enter = cur > 1;
      result = cur % 2 + result;
    }
    return enter ? "1" + result : result;
  }
}
