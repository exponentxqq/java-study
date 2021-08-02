package com.study.leetcode.array.easy;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * <p>每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * <p>请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 *
 * @number 746
 * @date 2021/5/10 4:28 PM
 */
public class MinCostClimbingStairs {
  /**
   * 设到达顶楼的体力花费最少为f[i]
   *
   * <p>f[i] = min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2])
   */
  public int minCostClimbingStairs(int[] cost) {
    int[] f = new int[cost.length + 1];
    f[0] = 0;
    f[1] = 0;
    for (int i = 2; i <= cost.length; i++) {
      f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
    }
    return f[cost.length];
  }
}
