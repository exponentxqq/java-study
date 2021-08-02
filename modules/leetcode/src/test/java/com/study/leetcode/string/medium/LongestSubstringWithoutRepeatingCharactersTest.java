package com.study.leetcode.string.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
  @Test
  void test1() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = "abcabcbb";

    int expected = 3;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }

  @Test
  void test2() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = "bbbbb";

    int expected = 1;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }

  @Test
  void test3() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = "pwwkew";

    int expected = 3;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }

  @Test
  void test4() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = " ";

    int expected = 1;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }

  @Test
  void test5() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = "";

    int expected = 0;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }

  @Test
  void test6() {
    final LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
        new LongestSubstringWithoutRepeatingCharacters();

    String s = "dvdf";

    int expected = 3;

    Assertions.assertEquals(
        expected, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }
}
