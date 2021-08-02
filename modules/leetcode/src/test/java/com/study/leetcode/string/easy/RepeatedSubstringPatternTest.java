package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatedSubstringPatternTest {
  @Test
  void test1() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "abab";

    boolean expected = true;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

  @Test
  void test2() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "aba";

    boolean expected = false;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

  @Test
  void test3() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "abcabcabcabc";

    boolean expected = true;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

  @Test
  void test4() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "a";

    boolean expected = false;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

  @Test
  void test5() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "abaababaab";

    boolean expected = true;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

  @Test
  void test6() {
    final RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();

    String s = "aabaaba";

    boolean expected = false;

    Assertions.assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
  }
}
