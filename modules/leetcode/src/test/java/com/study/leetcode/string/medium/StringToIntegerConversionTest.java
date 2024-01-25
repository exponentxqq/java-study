package com.study.leetcode.string.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToIntegerConversionTest {
  private final StringToIntegerConversion stringToIntegerConversion =
      new StringToIntegerConversion();

  @Test
  void test1() {
    String s = "   32";
    int expected = 32;

    Assertions.assertEquals(expected, stringToIntegerConversion.atoi(s));
  }

  @Test
  void test2() {
    String s = "-91283472332";
    int expected = -2147483648;

    Assertions.assertEquals(expected, stringToIntegerConversion.atoi(s));
  }

  @Test
  void test3() {
    String s = "2147483648";
    int expected = 2147483647;

    Assertions.assertEquals(expected, stringToIntegerConversion.atoi(s));
  }
}
