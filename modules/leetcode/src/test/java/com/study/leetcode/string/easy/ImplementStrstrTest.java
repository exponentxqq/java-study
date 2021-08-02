package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImplementStrstrTest {
  @Test
  void test1() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "hello";
    String needle = "ll";

    int expected = 2;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }

  @Test
  void test2() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "aaaaa";
    String needle = "bba";

    int expected = -1;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }

  @Test
  void test3() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "";
    String needle = "";

    int expected = 0;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }

  @Test
  void test4() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "";
    String needle = "a";

    int expected = -1;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }

  @Test
  void test5() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "aaa";
    String needle = "aaaa";

    int expected = -1;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }

  @Test
  void test6() {
    final ImplementStrstr implementStrstr = new ImplementStrstr();

    String haystack = "abcdefghijklmnopqrstuvwxyza";
    String needle = "za";

    int expected = 25;

    Assertions.assertEquals(expected, implementStrstr.strStr(haystack, needle));
  }
}
