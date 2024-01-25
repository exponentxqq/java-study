package com.study.leetcode.string.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerToRomanNumTest {
  private final IntegerToRomanNum integerToRomanNum = new IntegerToRomanNum();

  @Test
  void test1() {
    int num = 1994;
    String excepted = "MCMXCIV";

    Assertions.assertEquals(excepted, integerToRomanNum.intToRoman(num));
  }

  @Test
  void test2() {
    int num = 58;
    String excepted = "LVIII";

    Assertions.assertEquals(excepted, integerToRomanNum.intToRoman(num));
  }
}
