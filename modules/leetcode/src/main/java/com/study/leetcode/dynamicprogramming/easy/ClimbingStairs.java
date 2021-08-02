package com.study.leetcode.dynamicprogramming.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * <p>注意：给定 n 是一个正整数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @number 70
 * @date @date 2021/6/4 14:33 AM
 */
public class ClimbingStairs {
  /**
   * f[n]为到达最后一阶的方法数 <br>
   * 每一阶的方法数为前一阶+前前一阶的方法数之和<br>
   * f[n] = f[n - 1] + f[n - 2]; <br>
   * f[0]=f[1]=1
   */
  public int climbStairs(int n) {
    int[] f = new int[n + 1];
    f[0] = f[1] = 1;

    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }
}
