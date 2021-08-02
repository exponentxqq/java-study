package com.study.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。<br>
 * 如果不存在，则返回 -1。
 *
 * <p>提示：你可以假定该字符串只包含小写字母。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @number 387
 * @date 2021/6/9 17:10
 */
public class FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
    String t = s;
    Map<Character, Integer> found = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      final char ch = s.charAt(i);
      if (found.containsKey(ch)) {
        continue;
      }
      if (t.lastIndexOf(ch) == 0) {
        return i;
      }
      t = t.replace(String.valueOf(ch), "");
      found.put(ch, i);
    }
    return -1;
  }
  // 暴力求解
  public int firstUniqChar1(String s) {
    for (int i = 0; i < s.length(); i++) {
      if ((s.substring(0, i) + s.substring(i + 1)).indexOf(s.charAt(i)) < 0) {
        return i;
      }
    }
    return -1;
  }
}
