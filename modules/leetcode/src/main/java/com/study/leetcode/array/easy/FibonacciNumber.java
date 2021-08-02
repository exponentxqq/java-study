package com.study.leetcode.array.easy;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。<br>
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * <p>F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * <p>给你 n ，请计算 F(n) 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fibonacci-number
 *
 * @number 509
 * @date 2021/5/20 2:15 PM
 */
public class FibonacciNumber {
  public int fib1(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fib1(n - 2) + fib1(n - 1);
  }

  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    int pre1 = 0;
    int pre2 = 1;

    for (int i = 2; i <= n; i++) {
      int cur = pre1 + pre2;
      pre1 = pre2;
      pre2 = cur;
    }
    return pre2;
  }
}
