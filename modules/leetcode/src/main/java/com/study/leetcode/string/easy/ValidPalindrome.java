package com.study.leetcode.string.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * <p>说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @number 125
 * @date 2021/6/9 16:07
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);
      if (leftChar < '0'
          || (leftChar > '9' && leftChar < 'A')
          || (leftChar > 'Z' && leftChar < 'a')
          || leftChar > 'z') {
        left++;
        continue;
      }
      if (rightChar < '0'
          || (rightChar > '9' && rightChar < 'A')
          || (rightChar > 'Z' && rightChar < 'a')
          || rightChar > 'z') {
        right--;
        continue;
      }
      final String l = String.valueOf(leftChar);
      final String r = String.valueOf(rightChar);
      if (!l.equalsIgnoreCase(r)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
}
