package com.exp.leetcode.array.easy;

/**
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * <p>矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/transpose-matrix/
 *
 * @number 867
 * @date 2021/5/11 4:47 PM
 */
public class TransposeMatrix {
  public int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        result[j][i] = matrix[i][j];
      }
    }
    return result;
  }
}
