package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseVowelsOfAStringTest {
  @Test
  void test1() {
    final ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();

    String s = "hello";

    String expected = "holle";

    Assertions.assertEquals(expected, reverseVowelsOfAString.reverseVowels(s));
  }

  @Test
  void test2() {
    final ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();

    String s = "leetcode";

    String expected = "leotcede";

    Assertions.assertEquals(expected, reverseVowelsOfAString.reverseVowels(s));
  }

  @Test
  void test3() {
    final ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();

    String s = "a.";

    String expected = "a.";

    Assertions.assertEquals(expected, reverseVowelsOfAString.reverseVowels(s));
  }

  @Test
  void test4() {
    final ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();

    String s = "aA";

    String expected = "Aa";

    Assertions.assertEquals(expected, reverseVowelsOfAString.reverseVowels(s));
  }
}
