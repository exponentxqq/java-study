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
    int n = Math.min(matrix.length, matrix[0].length);
    int num = matrix[0][0];

    for (int i = 0; i < n; i++) {
      if (matrix[i][i] != num) {
        return false;
      }
    }
    return true;
  }
}
