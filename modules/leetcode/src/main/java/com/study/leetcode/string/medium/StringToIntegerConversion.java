package com.study.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串转换整数
 *
 * <p>请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * <p>函数 myAtoi(string s) 的算法如下：
 * <li>1. 读入字符串并丢弃无用的前导空格 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
 * <li>确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * <li>2. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * <li>将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
 * <li>如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * <li>如果整数数超过 32 位有符号整数范围 [−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。
 *
 *     <p>具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。 返回整数作为最终结果。
 *
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/string-to-integer-atoi/description/
 *
 * @number 8
 * @date 2024/1/25 17:08
 */
public class StringToIntegerConversion {
  public int atoi(String s) {
    String input = s.trim();
    if (input.isBlank()) {
      return 0;
    }
    boolean positive = input.charAt(0) != '-';
    int i = 0;
    if (input.charAt(0) == '-' || input.charAt(0) == '+') {
      i += 1;
    }
    List<Integer> nums = new ArrayList<>();
    for (; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        int num = input.charAt(i) - '0';
        nums.add(num);
      } else {
        break;
      }
    }

    long result = 0;
    for (int j = 0; j < nums.size(); j++) {
      double tmp = Math.pow(10, nums.size() - j - 1);
      double curr = tmp * nums.get(j);
      result += (int) curr * (positive ? 1 : -1);
      if (positive && result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (!positive && result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }

    return (int) result;
  }
}
