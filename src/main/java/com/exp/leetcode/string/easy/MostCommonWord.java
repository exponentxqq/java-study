package com.exp.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * <p>题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * <p>禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/most-common-word
 *
 * @number 819
 * @date 2021/6/15 16:42
 */
public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> countMap = new HashMap<>();

    int idx = 0;
    String word = "";
    while (idx < paragraph.length()) {
      char curCh = paragraph.charAt(idx);
      if ((curCh <= 'Z' && curCh >= 'A') || (curCh <= 'z' && curCh >= 'a')) {
        word += curCh;
      } else if (word.length() > 0) {
        if (countMap.containsKey(word.toLowerCase())) {
          countMap.put(word.toLowerCase(), countMap.get(word.toLowerCase()) + 1);
        } else {
          boolean isban = false;
          for (String s : banned) {
            if (s.equalsIgnoreCase(word)) {
              isban = true;
              break;
            }
          }
          if (!isban) {
            countMap.put(word.toLowerCase(), 1);
          }
        }

        word = "";
      }
      idx++;
    }

    if (word.length() != 0) {
      if (countMap.containsKey(word.toLowerCase())) {
        countMap.put(word.toLowerCase(), countMap.get(word.toLowerCase()) + 1);
      } else {
        countMap.put(word.toLowerCase(), 1);
      }
    }

    int max = 0;
    String result = word;
    for (String w : countMap.keySet()) {
      if (countMap.get(w) > max) {
        max = countMap.get(w);
        result = w;
      }
    }
    return result;
  }
}
