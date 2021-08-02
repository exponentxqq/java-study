package com.study.leetcode.string.easy;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。<br>
 * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * <p>单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/length-of-last-word
 *
 * @number 58
 * @date 2021/6/9 15:39
 */
public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    int endSpaceIdx = s.length();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        String word = s.substring(i + 1, endSpaceIdx);
        if (word.length() > 0) {
          return word.length();
        } else {
          endSpaceIdx = i;
        }
      }
    }
    return s.substring(0, endSpaceIdx).length();
  }
}
