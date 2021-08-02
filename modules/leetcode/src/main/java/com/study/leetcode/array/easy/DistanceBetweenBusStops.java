package com.study.leetcode.array.easy;

/**
 * 环形公交路线上有n个站，按次序从0到n - 1进行编号。<br>
 * 我们已知每一对相邻公交站之间的距离，<br>
 * distance[i]表示编号为i的车站和编号为(i + 1) % n的车站之间的距离。
 *
 * <p>环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * <p>返回乘客从出发点start到目的地destination之间的最短距离。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/distance-between-bus-stops
 *
 * @number 1184
 * @date 2021/5/24 11:25 PM
 */
public class DistanceBetweenBusStops {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int sum = 0;
    for (int item : distance) {
      sum += item;
    }

    int dest = 0;
    for (int i = Math.min(start, destination); i < Math.max(start, destination); i++) {
      dest += distance[i];
    }

    return Math.min(dest, sum - dest);
  }
}
