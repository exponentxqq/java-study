package com.exp.leetcode.string.easy;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，<br>
 * 同时仍保留空格和单词的初始顺序。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @number 557
 * @date 2021/6/12 00:18
 */
public class ReverseWordsInAStringIII {
  public String reverseWords(String s) {
    String result = "";

    String[] ss = s.split(" ");
    for (int i = 0; i < ss.length; i++) {
      String tmp = "";
      for (int j = 0; j < ss[i].length(); j++) {
        tmp = ss[i].charAt(j) + tmp;
      }
      if (i == ss.length - 1) {
        result += tmp;
      } else {
        result += tmp + " ";
      }
    }
    return result;
  }
}
