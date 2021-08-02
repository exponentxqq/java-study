package com.study.leetcode.dynamicprogramming.easy;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/counting-bits/
 *
 * @number 338
 * @date @date 2021/6/4 14:54 AM
 */
public class CountingBits {
  public int[] countBits(int n) {
    int[] bits = new int[n + 1];
    int highBit = 0;
    for (int i = 1; i <= n; i++) {
      // 当且仅当(i & (i - 1))==0时，i是2的整数次幂
      // 整数次幂时，i的二进制表示形式为 以1开头其余都是0
      if ((i & (i - 1)) == 0) {
        highBit = i;
      }
      bits[i] = bits[i - highBit] + 1;
    }
    return bits;
  }
}
