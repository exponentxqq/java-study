package com.study.leetcode.array.easy;

/**
 * 在一个XY 坐标系中有一些点，我们用数组coordinates来分别记录它们的坐标，其中coordinates[i] = [x, y]表示横坐标为 x、纵坐标为 y的点。
 *
 * <p>请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 *
 * @number 1232
 * @date 2021/5/25 12:35 AM
 */
public class CheckIfItIsAStraightLine {
  public boolean checkStraightLine(int[][] coordinates) {
    int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
    int n = coordinates.length;
    for (int i = 0; i < n; i++) {
      coordinates[i][0] -= deltaX;
      coordinates[i][1] -= deltaY;
    }
    int A = coordinates[1][1], B = -coordinates[1][0];
    for (int i = 2; i < n; i++) {
      int x = coordinates[i][0], y = coordinates[i][1];
      if (A * x + B * y != 0) {
        return false;
      }
    }
    return true;
  }
}
