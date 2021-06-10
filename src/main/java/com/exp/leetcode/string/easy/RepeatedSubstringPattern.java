package com.exp.leetcode.string.easy;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。<br>
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @number 459
 * @date 2021/6/9 17:13
 */
public class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String s) {
    if (s.length() < 2) {
      return false;
    }
    int maxGap = s.length() / 2;
    boolean t = true;

    int gap = 1;
    while (gap <= maxGap) {
      t = true;
      for (int j = 0; j < gap; j++) {
        for (int i = j; i < s.length() - gap; i += gap) {
          if (s.charAt(i) != s.charAt(i + gap)) {
            t = false;
            break;
          }
        }
        if (!t) {
          break;
        }
      }

      if (!t) {
        do {
          gap++;
        } while (gap <= maxGap && s.length() % gap != 0);
      } else {
        break;
      }
    }

    return t && gap <= maxGap;
  }
}
