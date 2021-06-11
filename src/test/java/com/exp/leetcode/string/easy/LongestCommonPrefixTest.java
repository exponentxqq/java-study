package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/26 8:56 PM */
public class LongestCommonPrefixTest {
  @Test
  void test1() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String[] strs = {"flower", "flow", "flight"};

    String expected = "fl";

    Assertions.assertEquals(expected, longestCommonPrefix.longestCommonPrefix(strs));
  }

  @Test
  void test2() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String[] strs = {"dog", "racecar", "car"};

    String expected = "";

    Assertions.assertEquals(expected, longestCommonPrefix.longestCommonPrefix(strs));
  }

  @Test
  void test3() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String[] strs = {"dog"};

    String expected = "dog";

    Assertions.assertEquals(expected, longestCommonPrefix.longestCommonPrefix(strs));
  }

  @Test
  void test4() {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String[] strs = {"dogest", "dog"};

    String expected = "dog";

    Assertions.assertEquals(expected, longestCommonPrefix.longestCommonPrefix(strs));
  }
}
