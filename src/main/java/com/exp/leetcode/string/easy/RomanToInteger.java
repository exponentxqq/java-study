package com.exp.leetcode.string.easy;

import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * <p>字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27
 * 写做XXVII, 即为XX+V+II。
 *
 * <p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
 * 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * <p>I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。 X可以放在L(50) 和C(100) 的左边，来表示 40 和90。 C可以放在D(500) 和M(1000)
 * 的左边，来表示400 和900。 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/roman-to-integer
 *
 * @number 13
 * @date 2021/5/26 8:36 PM
 */
public class RomanToInteger {
  public int romanToInt(String s) {
    Map<Character, Integer> map =
        Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    int result = map.get(s.charAt(s.length() - 1));
    for (int i = s.length() - 2; i >= 0; i--) {
      char c = s.charAt(i);
      char n = s.charAt(i + 1);
      if (c == 'I' && (n == 'X' || n == 'V')) {
        result -= map.get(c);
      } else if (c == 'X' && (n == 'L' || n == 'C')) {
        result -= map.get(c);
      } else if (c == 'C' && (n == 'D' || n == 'M')) {
        result -= map.get(c);
      } else {
        result += map.get(s.charAt(i));
      }
    }

    return result;
  }
}
