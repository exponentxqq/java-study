package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddStringsTest {
  @Test
  void test1() {
    final AddStrings addStrings = new AddStrings();

    String num1 = "12";
    String num2 = "3";

    String expected = "15";

    Assertions.assertEquals(expected, addStrings.addStrings(num1, num2));
  }

  @Test
  void test2() {
    final AddStrings addStrings = new AddStrings();

    String num1 = "1999";
    String num2 = "3";

    String expected = "2002";

    Assertions.assertEquals(expected, addStrings.addStrings(num1, num2));
  }
}
