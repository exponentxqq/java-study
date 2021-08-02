package com.study.leetcode.array.easy;

/**
 * 数轴上放置了一些筹码，每个筹码的位置存在数组chips当中。
 *
 * <p>你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * <p>将第 i 个筹码向左或者右移动 2 个单位，代价为 0。 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 * <p>返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position
 *
 * @number 1217
 * @date 2021/5/25 12:18 AM
 */
public class MinimumCostToMoveChipsToTheSamePosition {
  public int minCostToMoveChips(int[] position) {
    int oddCount = 0;
    int evenCount = 0;

    for (int item : position) {
      if (item % 2 == 0) {
        oddCount++;
      } else {
        evenCount++;
      }
    }
    return Math.min(oddCount, evenCount);
  }
}
