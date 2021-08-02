package com.study.leetcode.string.easy;

import java.util.List;

/**
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * <p>我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * <p>山羊拉丁文的规则如下：
 *
 * <p>如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 例如，单词"apple"变为"applema"。
 *
 * <p>如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 例如，单词"goat"变为"oatgma"。
 *
 * <p>根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 *
 * <p>返回将 S 转换为山羊拉丁文后的句子。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/goat-latin
 *
 * @number 824
 * @date 2021/6/15 16:42
 */
public class GoatLatin {
  public String toGoatLatin(String sentence) {
    List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    int idx = 0;
    String result = "";

    String word = "";
    int wordCount = 0;
    while (idx < sentence.length()) {
      char ch = sentence.charAt(idx);
      if (ch == ' ') {
        wordCount++;
        String tmp = "";
        char first = word.charAt(0);
        if (vowels.contains(first)) {
          tmp = word + "ma";
        } else {
          tmp = word.substring(1) + first + "ma";
        }
        for (int i = 0; i < wordCount; i++) {
          tmp += "a";
        }
        result += (tmp + " ");
        word = "";
      } else {
        word += ch;
      }
      idx++;
    }

    wordCount++;
    String tmp = "";
    char first = word.charAt(0);
    if (vowels.contains(first)) {
      tmp = word + "ma";
    } else {
      tmp = word.substring(1) + first + "ma";
    }
    for (int i = 0; i < wordCount; i++) {
      tmp += "a";
    }
    result += tmp;

    return result;
  }
}
