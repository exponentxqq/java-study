package com.study.leetcode.string.easy;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * <p>提示：
 *
 * <p>num1 和num2 的长度都小于 5100 <br>
 * num1 和num2 都只包含数字 0-9 <br>
 * num1 和num2 都不包含任何前导零 <br>
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-strings/
 *
 * @number 415
 * @date 2021/6/9 16:54
 */
public class AddStrings {
  public String addStrings(String num1, String num2) {
    String result = "";
    int i1 = num1.length() - 1;
    int i2 = num2.length() - 1;

    int cur = 0;
    boolean enter = false;
    while (i1 >= 0 || i2 >= 0) {
      if (i1 >= 0) {
        cur += num1.charAt(i1) - 48;
        i1--;
      }
      if (i2 >= 0) {
        cur += num2.charAt(i2) - 48;
        i2--;
      }

      enter = cur > 9;
      result = (cur % 10) + result;
      cur = enter ? 1 : 0;
    }
    return enter ? "1" + result : result;
  }
}
