package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/6/12 15:28 */
public class CountBinarySubstringsTest {
  @Test
  void test1() {
    CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();

    String s = "00110011";

    int expected = 6;

    Assertions.assertEquals(expected, countBinarySubstrings.countBinarySubstrings(s));
  }

  @Test
  void test2() {
    CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();

    String s = "10101";

    int expected = 4;

    Assertions.assertEquals(expected, countBinarySubstrings.countBinarySubstrings(s));
  }
}
