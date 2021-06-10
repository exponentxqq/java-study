package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestUncommonSubsequenceITest {
  @Test
  void test1() {
    final LongestUncommonSubsequenceI longestUncommonSubsequenceI =
        new LongestUncommonSubsequenceI();

    String a = "aba";
    String b = "cdc";

    int expected = 3;

    Assertions.assertEquals(expected, longestUncommonSubsequenceI.findLUSlength(a, b));
  }

  @Test
  void test2() {
    final LongestUncommonSubsequenceI longestUncommonSubsequenceI =
        new LongestUncommonSubsequenceI();

    String a = "aaa";
    String b = "bbb";

    int expected = 3;

    Assertions.assertEquals(expected, longestUncommonSubsequenceI.findLUSlength(a, b));
  }

  @Test
  void test3() {
    final LongestUncommonSubsequenceI longestUncommonSubsequenceI =
        new LongestUncommonSubsequenceI();

    String a = "aaa";
    String b = "aaa";

    int expected = -1;

    Assertions.assertEquals(expected, longestUncommonSubsequenceI.findLUSlength(a, b));
  }

  @Test
  void test4() {
    final LongestUncommonSubsequenceI longestUncommonSubsequenceI =
        new LongestUncommonSubsequenceI();

    String a = "aefeaf";
    String b = "a";

    int expected = 6;

    Assertions.assertEquals(expected, longestUncommonSubsequenceI.findLUSlength(a, b));
  }

  @Test
  void test5() {
    final LongestUncommonSubsequenceI longestUncommonSubsequenceI =
        new LongestUncommonSubsequenceI();

    String a = "abcd";
    String b = "";

    int expected = 4;

    Assertions.assertEquals(expected, longestUncommonSubsequenceI.findLUSlength(a, b));
  }
}
