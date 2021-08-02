package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 4:34 PM */
public class PascalsTriangleTest {
  @Test
  void test1() {
    PascalsTriangle pascalsTriangle = new PascalsTriangle();

    int numRows = 5;

    List<List<Integer>> expect =
        List.of(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1));

    Assertions.assertEquals(expect, pascalsTriangle.generate(numRows));
  }
}
