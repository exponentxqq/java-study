package com.exp.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * <p>假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），<br>
 * 那么我们就认为你掌握了这个单词。
 *
 * <p>注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * <p>返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 *
 * @number 1160
 * @date 2021/5/21 10:49 AM
 */
public class FindWordsThatCanBeFormedByCharacters {
  public int countCharacters(String[] words, String chars) {
    Map<Character, Integer> charsCountMap = new HashMap<>();
    for (int i = 0; i < chars.length(); i++) {
      final char curChar = chars.charAt(i);
      if (charsCountMap.containsKey(curChar)) {
        charsCountMap.put(curChar, charsCountMap.get(curChar) + 1);
      } else {
        charsCountMap.put(curChar, 1);
      }
    }
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() > chars.length()) {
        continue;
      }
      Map<Character, Integer> matchedMap = new HashMap<>();
      int matchedLength = 0;
      for (int j = 0; j < words[i].length(); j++) {
        final char cur = words[i].charAt(j);
        if (charsCountMap.containsKey(cur)) {
          matchedMap.put(cur, matchedMap.containsKey(cur) ? matchedMap.get(cur) + 1 : 1);
          matchedLength++;
          if (matchedMap.get(cur) > charsCountMap.get(cur)) {
            matchedMap = new HashMap<>();
            matchedLength = 0;
            break;
          }
        } else {
          matchedMap = new HashMap<>();
          matchedLength = 0;
          break;
        }
      }
      count += matchedLength;
    }
    return count;
  }
}
