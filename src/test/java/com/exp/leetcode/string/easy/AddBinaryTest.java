package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinaryTest {
  @Test
  void test1() {
    final AddBinary addBinary = new AddBinary();

    String a = "11";
    String b = "1";

    String expected = "100";

    Assertions.assertEquals(expected, addBinary.addBinary(a, b));
  }

  @Test
  void test2() {
    final AddBinary addBinary = new AddBinary();

    String a = "1010";
    String b = "1011";

    String expected = "10101";

    Assertions.assertEquals(expected, addBinary.addBinary(a, b));
  }

  @Test
  void test3() {
    final AddBinary addBinary = new AddBinary();

    String a = "1011";
    String b = "1011";

    String expected = "10110";

    Assertions.assertEquals(expected, addBinary.addBinary(a, b));
  }
}
