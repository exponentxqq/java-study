package com.study.leetcode.string.easy;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * @number 680
 * @date 2021/6/12 15:06
 */
public class ValidPalindromeII {
  public boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      char chl = s.charAt(left);
      char chr = s.charAt(right);

      if (chl != chr) {
        return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
      } else {
        left++;
        right--;
      }
    }

    return true;
  }

  public boolean validPalindrome(String s, int low, int high) {
    for (int i = low, j = high; i < j; ++i, --j) {
      char c1 = s.charAt(i), c2 = s.charAt(j);
      if (c1 != c2) {
        return false;
      }
    }
    return true;
  }
}
