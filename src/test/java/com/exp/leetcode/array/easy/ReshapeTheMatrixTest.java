package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReshapeTheMatrixTest {
  @Test
  void test1() {
    final ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();

    int[][] mat = {{1, 2}, {3, 4}};
    int r = 1;
    int c = 4;

    int[][] expect = {{1, 2, 3, 4}};

    Assertions.assertArrayEquals(expect, reshapeTheMatrix.matrixReshape(mat, r, c));
  }

  @Test
  void test2() {
    final ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();

    int[][] mat = {{1, 2}, {3, 4}};
    int r = 2;
    int c = 4;

    int[][] expect = {{1, 2}, {3, 4}};

    Assertions.assertArrayEquals(expect, reshapeTheMatrix.matrixReshape(mat, r, c));
  }

  @Test
  void test3() {
    final ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();

    int[][] mat = {{1, 2}, {3, 4}};
    int r = 4;
    int c = 1;

    int[][] expect = {{1}, {2}, {3}, {4}};

    Assertions.assertArrayEquals(expect, reshapeTheMatrix.matrixReshape(mat, r, c));
  }

  @Test
  void test4() {
    final ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();

    int[][] mat = {{1, 2}};
    int r = 1;
    int c = 1;

    int[][] expect = {{1, 2}};

    Assertions.assertArrayEquals(expect, reshapeTheMatrix.matrixReshape(mat, r, c));
  }
}
