package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuddyStringsTest {
  @Test
  void test1() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "ab";
    String goal = "ba";

    boolean expected = true;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }

  @Test
  void test2() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "ab";
    String goal = "ab";

    boolean expected = false;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }

  @Test
  void test3() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "aa";
    String goal = "aa";

    boolean expected = true;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }

  @Test
  void test4() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "";
    String goal = "aa";

    boolean expected = false;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }

  @Test
  void test5() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "aaaaaaabc";
    String goal = "aaaaaaacb";

    boolean expected = true;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }

  @Test
  void test6() {
    final BuddyStrings buddyStrings = new BuddyStrings();

    String s = "abab";
    String goal = "abab";

    boolean expected = true;

    Assertions.assertEquals(expected, buddyStrings.buddyStrings(s, goal));
  }
}
