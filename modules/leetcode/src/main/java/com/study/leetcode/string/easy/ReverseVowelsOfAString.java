package com.study.leetcode.string.easy;

import java.util.Map;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * @number 345
 * @date 2021/6/9 16:36
 */
public class ReverseVowelsOfAString {
  public String reverseVowels(String s) {
    Map<Character, Boolean> vowels =
        Map.of(
            'a', true, 'e', true, 'i', true, 'o', true, 'u', true, 'A', true, 'E', true, 'I', true,
            'O', true, 'U', true);

    int l = 0;
    int r = s.length() - 1;
    String resultLeft = "";
    String resultRight = "";

    while (l <= r) {
      char left = s.charAt(l);
      char right = s.charAt(r);
      if (!vowels.containsKey(left)) {
        resultLeft += left;
        l++;
        continue;
      }
      if (!vowels.containsKey(right)) {
        resultRight = right + resultRight;
        r--;
        continue;
      }
      resultLeft += right;
      if (r != l) {
        resultRight = left + resultRight;
      }

      l++;
      r--;
    }

    return resultLeft + resultRight;
  }
}
