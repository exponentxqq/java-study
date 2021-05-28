package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransposeMatrixTest {
  @Test
  void test1() {
    final TransposeMatrix transposeMatrix = new TransposeMatrix();

    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
    };

    int[][] expected = {
      {1, 4, 7},
      {2, 5, 8},
      {3, 6, 9},
    };

    Assertions.assertArrayEquals(expected, transposeMatrix.transpose(matrix));
  }

  @Test
  void test2() {
    final TransposeMatrix transposeMatrix = new TransposeMatrix();

    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
    };

    int[][] expected = {
      {1, 4},
      {2, 5},
      {3, 6},
    };

    Assertions.assertArrayEquals(expected, transposeMatrix.transpose(matrix));
  }
}
