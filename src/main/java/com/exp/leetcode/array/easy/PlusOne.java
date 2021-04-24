package com.exp.leetcode.array.easy;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * <p>最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * <p>你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/plus-one
 *
 * @version 66
 * @date 2021/4/23 8:46 PM
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >=0; i--) {
      int tmp = digits[i] + 1;
      if (tmp == 10) {
        digits[i] = 0;
      } else {
        digits[i]++;
        break;
      }
    }
    if (digits[0] == 0) {
      digits = new int[digits.length + 1];
      digits[0] = 1;
    }
    return digits;
  }
}
