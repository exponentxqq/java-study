package com.study.leetcode.string.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZShapedTransformationTest {
  private final ZShapedTransformation zShapedTransformation = new ZShapedTransformation();

  @Test
  void test1() {
    String s = "PAYPALISHIRING";
    String expected = "PAHNAPLSIIGYIR";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 3));
  }

  @Test
  void test2() {
    String s = "PAYPALISHIRING";
    String expected = "PINALSIGYAHRPI";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 4));
  }

  @Test
  void test3() {
    String s = "A";
    String expected = "A";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 1));
  }

  @Test
  void test4() {
    String s = "AB";
    String expected = "AB";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 2));
  }

  @Test
  void test5() {
    String s = "AB";
    String expected = "AB";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 1));
  }

  @Test
  void test6() {
    String s = "ABC";
    String expected = "ACB";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 2));
  }

  @Test
  void test7() {
    String s = "ABC";
    String expected = "ABC";

    Assertions.assertEquals(expected, zShapedTransformation.convert(s, 1));
  }
}
