package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 4:44 PM */
public class PascalsTriangle2Test {
  @Test
  void test() {
    PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();

    int rowIndex = 3;

    List<Integer> expect = List.of(1, 3, 3, 1);

    Assertions.assertEquals(expect, pascalsTriangle2.getRow(rowIndex));
  }
}
