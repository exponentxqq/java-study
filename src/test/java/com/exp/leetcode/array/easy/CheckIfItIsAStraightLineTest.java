package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/25 12:35 AM */
public class CheckIfItIsAStraightLineTest {
  @Test
  void test1() {
    CheckIfItIsAStraightLine checkIfItIsAStraightLine = new CheckIfItIsAStraightLine();

    int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

    boolean expected = true;

    Assertions.assertEquals(expected, checkIfItIsAStraightLine.checkStraightLine(coordinates));
  }
}
