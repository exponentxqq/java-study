package com.exp.leetcode.string.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * <p>有效字符串需满足：
 *
 * <p>左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @number 20
 * @date 2021/5/26 9:08 PM
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }
    Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    Deque<Character> deque = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        Character poll = deque.poll();
        if (poll != map.get(ch)) {
          return false;
        }
      } else {
        deque.push(ch);
      }
    }
    return deque.size() == 0;
  }
}
