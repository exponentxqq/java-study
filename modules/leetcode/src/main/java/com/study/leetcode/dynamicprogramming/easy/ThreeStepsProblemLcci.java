package com.study.leetcode.dynamicprogramming.easy;

/**
 * 三步问题。
 *
 * <p>有个小孩正在上楼梯，楼梯有n阶台阶,小孩一次可以上1阶、2阶或3阶。<br>
 * 实现一种方法，计算小孩有多少种上楼梯的方式。<br>
 * 结果可能很大，你需要对结果模1000000007。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 *
 * @number interview 08.01
 * @date @date 2021/6/9 10:23
 */
public class ThreeStepsProblemLcci {
  // f[i] = f[i - 1] + i;
  // f[0] = 1;
  public int waysToStep(int n) {
    long[] f = new long[n];
    if (n < 3) {
      return new int[] {1, 2, 4}[n - 1];
    }

    f[0] = 1;
    f[1] = 2;
    f[2] = 4;
    for (int i = 3; i < n; i++) {
      f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % 1000000007;
    }
    return (int) f[n - 1];
  }
}
