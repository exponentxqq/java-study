package com.study.leetcode.array.easy;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 * @number 121
 * @date 2021/4/24 5:14 PM
 */
public class BestTimeToBuyAndSellStock {
  /** 暴力求解 */
  public int maxProfit1(int[] prices) {
    int max = 0;

    for (int i = 0; i < prices.length; i++) {
      for (int j = i; j >= 0; j--) {
        max = Math.max(max, prices[i] - prices[j]);
      }
    }
    return max;
  }

  public int maxProfit2(int[] prices) {
    int min = prices[0];
    int max = 0;

    for (int i = 1; i < prices.length; i++) {
      max = Math.max(max, prices[i] - min);
      min = Math.min(min, prices[i]);
    }

    return max;
  }
}
