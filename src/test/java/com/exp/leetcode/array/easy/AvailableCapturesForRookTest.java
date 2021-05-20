package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvailableCapturesForRookTest {
  @Test
  void test1() {
    final AvailableCapturesForRook availableCapturesForRook = new AvailableCapturesForRook();

    char[][] board = {
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', 'p', '.', '.', '.', '.'},
      {'.', '.', '.', 'R', '.', '.', '.', 'p'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', 'p', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'}
    };

    int expected = 3;

    Assertions.assertEquals(expected, availableCapturesForRook.numRookCaptures(board));
  }

  @Test
  void test2() {
    final AvailableCapturesForRook availableCapturesForRook = new AvailableCapturesForRook();

    char[][] board = {
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
      {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
      {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
      {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
      {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'}
    };

    int expected = 0;

    Assertions.assertEquals(expected, availableCapturesForRook.numRookCaptures(board));
  }
}
