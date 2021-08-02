package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthOfLastWordTest {
  @Test
  void test1() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "Hello World";

    int expected = 5;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }

  @Test
  void test2() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = " ";

    int expected = 0;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }

  @Test
  void test3() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "car";

    int expected = 3;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }

  @Test
  void test4() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "a  ";

    int expected = 1;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }

  @Test
  void test5() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "        ";

    int expected = 0;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }

  @Test
  void test6() {
    final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "i want book ";

    int expected = 4;

    Assertions.assertEquals(expected, lengthOfLastWord.lengthOfLastWord(s));
  }
}
