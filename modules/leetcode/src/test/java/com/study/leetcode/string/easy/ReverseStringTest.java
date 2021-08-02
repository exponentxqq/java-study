package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {
  @Test
  void test1() {
    final ReverseString reverseString = new ReverseString();

    char[] s = {'h', 'e', 'l', 'l', 'o'};

    char[] expected = {'o', 'l', 'l', 'e', 'h'};

    reverseString.reverseString(s);
    Assertions.assertArrayEquals(expected, s);
  }

  @Test
  void test2() {
    final ReverseString reverseString = new ReverseString();

    char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};

    char[] expected = {'h', 'a', 'n', 'n', 'a', 'H'};

    reverseString.reverseString(s);
    Assertions.assertArrayEquals(expected, s);
  }
}
