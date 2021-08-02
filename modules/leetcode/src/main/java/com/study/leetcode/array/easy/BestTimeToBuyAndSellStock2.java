package com.study.leetcode.array.easy;

/**
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *
 * <p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * @number 122
 * @date 2021/4/24 5:27 PM
 */
public class BestTimeToBuyAndSellStock2 {
  /**
   * 动态规划
   *
   * <p>每天都有两种可能，一种是继续持有股票，一种是卖出了股票<br>
   * 设f[i][0]为每天卖出的最大收益，设f[i][1]为每天持有股票的最大收益<br>
   *
   * <ul>
   *   每天卖出的最大利润为前一天卖出的最大利润和当前卖出的最大利润取最大值，当天卖出的最大利润为前一天持有的最大利润在当前卖出，即为f[i - 1][1] + prices[i]<br>
   *   f[i][0] = max(f[i - 1][0], f[i - 1][1] + prices[i])<br>
   *   <li>每天持有的最大利润 f[i][1] = max(f[i - 1][1], f[i - 1][0] - prices[i])<br>
   * </ul>
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] f = new int[n][2];
    f[0][0] = 0;
    f[0][1] = -prices[0];
    for (int i = 1; i < n; ++i) {
      f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
      f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
    }
    return f[n - 1][0];
  }
}
