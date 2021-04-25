package com.exp.leetcode.array.easy;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * <p>给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * <p>重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * <p>如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 *
 * @number 566
 * @date 2021/4/25 3:38 PM
 */
public class ReshapeTheMatrix {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    if (r * c != mat.length * mat[0].length) {
      return mat;
    }

    int[][] res = new int[r][c];
    int x = 0;
    int y = 0;

    for (int[] ints : mat) {
      for (int j = 0; j < mat[0].length; j++) {
        res[x][y] = ints[j];
        y++;
        if (y == c) {
          x++;
          y = 0;
        }
      }
    }

    return res;
  }
}
