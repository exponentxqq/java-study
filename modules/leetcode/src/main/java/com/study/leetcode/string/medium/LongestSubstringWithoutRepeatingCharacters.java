package com.study.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @number 3
 * @date 2021/6/9 15:52
 */
public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int max = 0;
    int i = 0;
    for (; i < s.length(); i++) {
      final char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        max = Math.max(max, map.size());
        i = map.get(ch);
        map.clear();
      } else {
        map.put(ch, i);
      }
    }
    return Math.max(max, map.size());
  }
}
