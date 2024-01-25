package com.study.leetcode.string.medium;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPalindromeSubstringTest {
  private final LongestPalindromeSubstring longestPalindromeSubstring =
      new LongestPalindromeSubstring();

  @Test
  void test1() {
    String s = "babad";
    List<String> expected = List.of("bab", "aba");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test2() {
    String s = "aacabdkacaa";
    List<String> expected = List.of("aca");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test3() {
    String s = "cbbd";
    List<String> expected = List.of("bb");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test4() {
    String s = "abcdefghc";
    List<String> expected = List.of("a");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test5() {
    String s = "a";
    List<String> expected = List.of("a");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test6() {
    String s = "ac";
    List<String> expected = List.of("a", "c");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test7() {
    String s = "bb";
    List<String> expected = List.of("bb");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test8() {
    String s = "";
    List<String> expected = List.of("");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }

  @Test
  void test9() {
    String s = "ccc";
    List<String> expected = List.of("ccc");
    Assertions.assertTrue(expected.contains(longestPalindromeSubstring.longestPalindrome2(s)));
  }
}
