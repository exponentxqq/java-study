package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupsOfSpecialEquivalentStringsTest {
  @Test
  void test1() {
    final GroupsOfSpecialEquivalentStrings groupsOfSpecialEquivalentStrings =
        new GroupsOfSpecialEquivalentStrings();

    String[] words = {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};

    int expected = 3;

    Assertions.assertEquals(
        expected, groupsOfSpecialEquivalentStrings.numSpecialEquivGroups(words));
  }

  @Test
  void test2() {
    final GroupsOfSpecialEquivalentStrings groupsOfSpecialEquivalentStrings =
        new GroupsOfSpecialEquivalentStrings();

    String[] words = {"abc", "acb", "bac", "bca", "cab", "cba"};

    int expected = 3;

    Assertions.assertEquals(
        expected, groupsOfSpecialEquivalentStrings.numSpecialEquivGroups(words));
  }

  @Test
  void test3() {
    final GroupsOfSpecialEquivalentStrings groupsOfSpecialEquivalentStrings =
        new GroupsOfSpecialEquivalentStrings();

    String[] words = {"ababaa", "aaabaa"};

    int expected = 2;

    Assertions.assertEquals(
        expected, groupsOfSpecialEquivalentStrings.numSpecialEquivGroups(words));
  }
}
