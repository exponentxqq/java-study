package com.exp.leetcode.array.easy;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * <p>现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 *
 * @number 697
 * @date 2021/5/10 1:31 PM
 */
public class OneBitAndTwoBitCharacters {
  public boolean isOneBitCharacter(int[] bits) {
    if (bits.length == 1) {
      return true;
    }

    boolean matched = false;

    for (int i = 0; i < bits.length; i++) {
      if (bits[i] == 1) {
        i++;
        if (i == bits.length - 1) {
          matched = true;
        }
      }
    }

    return !matched;
  }
}
