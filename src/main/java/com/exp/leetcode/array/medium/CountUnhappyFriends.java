package com.exp.leetcode.array.medium;

/**
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 *
 * <p>对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。<br>
 * 换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 *
 * <p>所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 *
 * <p>但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 *
 * <p>x 与 u 的亲近程度胜过 x 与 y，且 u 与 x 的亲近程度胜过 u 与 v
 *
 * <p>返回 不开心的朋友的数目 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-unhappy-friends
 *
 * @incomplete
 * @number 1583
 * @date @date 2021/4/26 9:50 AM
 */
public class CountUnhappyFriends {
  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    int unhappy = 0;

    int[][] orders = new int[n][1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        orders[i][preferences[i][j]] = j;
      }
    }

    for (int i = 0; i < pairs.length; i++) {
      final int x = pairs[i][0];
      final int y = pairs[i][1];

      int closestX = preferences[x][0];
      int closestY = preferences[y][0];
    }
    return unhappy;
  }
}
