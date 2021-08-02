package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/25 12:19 AM */
public class MinimumCostToMoveChipsToTheSamePositionTest {
  @Test
  void test1() {
    MinimumCostToMoveChipsToTheSamePosition minimumCostToMoveChipsToTheSamePosition =
        new MinimumCostToMoveChipsToTheSamePosition();

    int[] position = {1, 2, 3};

    int expected = 1;

    Assertions.assertEquals(
        expected, minimumCostToMoveChipsToTheSamePosition.minCostToMoveChips(position));
  }

  @Test
  void test2() {
    MinimumCostToMoveChipsToTheSamePosition minimumCostToMoveChipsToTheSamePosition =
        new MinimumCostToMoveChipsToTheSamePosition();

    int[] position = {2, 2, 2, 3, 3};

    int expected = 2;

    Assertions.assertEquals(
        expected, minimumCostToMoveChipsToTheSamePosition.minCostToMoveChips(position));
  }
}
