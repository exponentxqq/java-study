package com.study.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * <p>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * @number 17
 * @date 2024/1/25 10:08
 */
public class LetterCombinationsOfAPhoneNumber {
  private static final Map<Integer, List<String>> LETTERS_MAP =
      Map.of(
          2,
          List.of("a", "b", "c"),
          3,
          List.of("d", "e", "f"),
          4,
          List.of("g", "h", "i"),
          5,
          List.of("j", "k", "l"),
          6,
          List.of("m", "n", "o"),
          7,
          List.of("p", "q", "r"),
          8,
          List.of("t", "u", "v"),
          9,
          List.of("w", "x", "y", "z"));

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    final List<List<String>> letters = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      int num = digits.charAt(i) - '0';
      letters.add(LETTERS_MAP.get(num));
    }

    int deep = letters.size();
  }
}
