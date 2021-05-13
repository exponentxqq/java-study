package com.exp.leetcode.array.easy;

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * <p>如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 *
 * @number 766
 * @date 2021/5/10 5:01 PM
 */
public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (i + 1 >= matrix.length) {
          continue;
        }
        if (j + 1 >= matrix[i].length) {
          continue;
        }
        if (matrix[i][j] != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
