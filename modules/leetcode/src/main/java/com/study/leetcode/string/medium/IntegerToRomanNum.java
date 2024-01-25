package com.study.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数转罗马数字
 *
 * <p>罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * <pre>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 *
 * <p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
 * 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <li>I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * <li>X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * <li>C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 *     <p>给你一个整数，将其转为罗马数字。1 <= num <= 3999
 *
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/integer-to-roman/description/
 *
 * @number 13
 * @date 2024/1/25 17:08
 */
public class IntegerToRomanNum {
  private static final Map<Integer, String> ROMAN_MAP = new HashMap<>();

  static {
    ROMAN_MAP.put(1, "I");
    ROMAN_MAP.put(4, "IV");
    ROMAN_MAP.put(5, "V");
    ROMAN_MAP.put(9, "IX");
    ROMAN_MAP.put(10, "X");
    ROMAN_MAP.put(40, "XL");
    ROMAN_MAP.put(50, "L");
    ROMAN_MAP.put(90, "XC");
    ROMAN_MAP.put(100, "C");
    ROMAN_MAP.put(400, "CD");
    ROMAN_MAP.put(500, "D");
    ROMAN_MAP.put(900, "CM");
    ROMAN_MAP.put(1000, "M");
  }

  public String intToRoman(int num) {
    StringBuilder result = new StringBuilder();

    m(num, 1000, result);
    int input = num % 1000;
    m(input, 100, result);
    input = input % 100;
    m(input, 10, result);
    input = input % 10;
    m(input, 1, result);

    return result.toString();
  }

  private void m(int input, int m, StringBuilder result) {
    int i = input / m;
    if (i == 9) {
      result.append(ROMAN_MAP.get(9 * m));
    } else if (i >= 5) {
      result.append(ROMAN_MAP.get(5 * m));
      for (int j = 5; j < i; j++) {
        result.append(ROMAN_MAP.get(m));
      }
    } else if (i == 4) {
      result.append(ROMAN_MAP.get(4 * m));
    } else {
      for (int j = 0; j < i; j++) {
        result.append(ROMAN_MAP.get(m));
      }
    }
  }
}
