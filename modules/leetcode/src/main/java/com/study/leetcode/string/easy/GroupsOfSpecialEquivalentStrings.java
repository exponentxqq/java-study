package com.study.leetcode.string.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你将得到一个字符串数组 A。
 *
 * <p>每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
 *
 * <p>如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
 *
 * <p>例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy"
 * -> "xyzz" 。
 *
 * <p>现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：
 *
 * <p>该组中的每一对字符串都是 特殊等价 的 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会
 * 与该组内任何字符串特殊等价）
 *
 * <p>返回 A 中特殊等价字符串组的数量。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
 *
 * @incomplete
 * @number 893
 * @date 2021/6/17 10:22
 */
public class GroupsOfSpecialEquivalentStrings {
  public int numSpecialEquivGroups(String[] words) {
    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      if (map.isEmpty()) {
        map.put(word, 1);
      } else {
        boolean found = false;
        for (String s : map.keySet()) {
          if (isSpecialEquivalentString(s, word)) {
            map.put(s, map.get(s) + 1);
            found = true;
            break;
          }
        }
        if (!found) {
          map.put(word, 1);
        }
      }
    }
    return map.size();
  }

  public boolean isSpecialEquivalentString(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    List<Character> evenA = new ArrayList<>();
    List<Character> evenB = new ArrayList<>();
    List<Character> oddA = new ArrayList<>();
    List<Character> oddB = new ArrayList<>();
    int evenIdx = 0;
    int oddIdx = 1;
    while (evenIdx < a.length()) {
      char charA = a.charAt(evenIdx);
      char charB = b.charAt(evenIdx);
      evenA.add(charA);
      evenB.add(charB);
      evenIdx += 2;
    }
    while (oddIdx < a.length()) {
      char charA = a.charAt(oddIdx);
      char charB = b.charAt(oddIdx);
      oddA.add(charA);
      oddB.add(charB);
      oddIdx += 2;
    }
    return oddA.stream().sorted().equals(oddB.stream().sorted())
        && evenA.stream().sorted().equals(evenB.stream().sorted());
  }
}
