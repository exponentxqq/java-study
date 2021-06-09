package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfSegmentsInAStringTest {
  @Test
  void test1() {
    final NumberOfSegmentsInAString numberOfSegmentsInAString = new NumberOfSegmentsInAString();

    String s = "Hello, my name is John";

    int expected = 5;

    Assertions.assertEquals(expected, numberOfSegmentsInAString.countSegments(s));
  }

  @Test
  void test2() {
    final NumberOfSegmentsInAString numberOfSegmentsInAString = new NumberOfSegmentsInAString();

    String s = "  ";

    int expected = 0;

    Assertions.assertEquals(expected, numberOfSegmentsInAString.countSegments(s));
  }

  @Test
  void test3() {
    final NumberOfSegmentsInAString numberOfSegmentsInAString = new NumberOfSegmentsInAString();

    String s = ", , , ,        a, eaefa";

    int expected = 6;

    Assertions.assertEquals(expected, numberOfSegmentsInAString.countSegments(s));
  }
}
