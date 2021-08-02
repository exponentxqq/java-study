package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/26 8:52 PM */
public class RomanToIntegerTest {
  @Test
  void test1() {
    RomanToInteger romanToInteger = new RomanToInteger();

    String s = "III";

    int expected = 3;

    Assertions.assertEquals(expected, romanToInteger.romanToInt(s));
  }

  @Test
  void test2() {
    RomanToInteger romanToInteger = new RomanToInteger();

    String s = "IV";

    int expected = 4;

    Assertions.assertEquals(expected, romanToInteger.romanToInt(s));
  }

  @Test
  void test3() {
    RomanToInteger romanToInteger = new RomanToInteger();

    String s = "LVIII";

    int expected = 58;

    Assertions.assertEquals(expected, romanToInteger.romanToInt(s));
  }

  @Test
  void test4() {
    RomanToInteger romanToInteger = new RomanToInteger();

    String s = "MCMXCIV";

    int expected = 1994;

    Assertions.assertEquals(expected, romanToInteger.romanToInt(s));
  }
}
