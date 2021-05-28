package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToeplitzMatrixTest {
  @Test
  void test1() {
    final ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 1, 2, 3},
      {9, 5, 1, 2}
    };

    boolean expect = true;

    Assertions.assertEquals(expect, toeplitzMatrix.isToeplitzMatrix(matrix));
  }

  @Test
  void test2() {
    final ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

    int[][] matrix = {
      {1, 2},
      {2, 2}
    };

    boolean expect = false;

    Assertions.assertEquals(expect, toeplitzMatrix.isToeplitzMatrix(matrix));
  }

  @Test
  void test3() {
    final ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

    int[][] matrix = {
      {11, 74, 0, 93},
      {40, 11, 74, 7}
    };

    boolean expect = false;

    Assertions.assertEquals(expect, toeplitzMatrix.isToeplitzMatrix(matrix));
  }

  @Test
  void test4() {
    final ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

    int[][] matrix = {
      {11, 74, 0, 93},
      {40, 11, 74, 0},
      {2, 10, 11, 74},
    };

    boolean expect = false;

    Assertions.assertEquals(expect, toeplitzMatrix.isToeplitzMatrix(matrix));
  }
}
