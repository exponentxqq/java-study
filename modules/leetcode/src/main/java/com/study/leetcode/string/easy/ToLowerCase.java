package com.study.leetcode.string.easy;

/**
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/to-lower-case/
 *
 * @number 709
 * @date 2021/6/12 15:40
 */
public class ToLowerCase {

  /**
   * 大写变小写、小写变大写：字符 ^= 32 （大写 ^= 32 相当于 +32，小写 ^= 32 相当于 -32）<br>
   * 大写变小写、小写变小写：字符 |= 32 （大写 |= 32 就相当于+32，小写 |= 32 不变）<br>
   * 大写变大写、小写变大写：字符 &= -33 （大写 ^= -33 不变，小写 ^= -33 相当于 -32）
   */
  public String toLowerCase(String s) {
    String result = "";

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        result += (char) (ch + ('a' - 'A'));
      } else {
        result += ch;
      }
    }

    return result;
  }
}
