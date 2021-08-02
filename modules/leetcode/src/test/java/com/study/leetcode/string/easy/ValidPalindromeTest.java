package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
  @Test
  void test1() {
    final ValidPalindrome validPalindrome = new ValidPalindrome();

    String s = "A man, a plan, a canal: Panama";

    boolean expected = true;

    Assertions.assertEquals(expected, validPalindrome.isPalindrome(s));
  }

  @Test
  void test2() {
    final ValidPalindrome validPalindrome = new ValidPalindrome();

    String s = "race a car";

    boolean expected = false;

    Assertions.assertEquals(expected, validPalindrome.isPalindrome(s));
  }

  @Test
  void test3() {
    final ValidPalindrome validPalindrome = new ValidPalindrome();

    String s = "0P";

    boolean expected = false;

    Assertions.assertEquals(expected, validPalindrome.isPalindrome(s));
  }

  @Test
  void test4() {
    final ValidPalindrome validPalindrome = new ValidPalindrome();

    String s = "ab_a";

    boolean expected = true;

    Assertions.assertEquals(expected, validPalindrome.isPalindrome(s));
  }
}
