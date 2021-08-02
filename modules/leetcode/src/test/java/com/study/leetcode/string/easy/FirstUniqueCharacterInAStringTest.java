package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstUniqueCharacterInAStringTest {
  @Test
  void test1() {
    final FirstUniqueCharacterInAString firstUniqueCharacterInAString =
        new FirstUniqueCharacterInAString();

    String s = "leetcode";

    int expected = 0;

    Assertions.assertEquals(expected, firstUniqueCharacterInAString.firstUniqChar(s));
  }

  @Test
  void test2() {
    final FirstUniqueCharacterInAString firstUniqueCharacterInAString =
        new FirstUniqueCharacterInAString();

    String s = "loveleetcode";

    int expected = 2;

    Assertions.assertEquals(expected, firstUniqueCharacterInAString.firstUniqChar(s));
  }

  @Test
  void test3() {
    final FirstUniqueCharacterInAString firstUniqueCharacterInAString =
        new FirstUniqueCharacterInAString();

    String s = "aabb";

    int expected = -1;

    Assertions.assertEquals(expected, firstUniqueCharacterInAString.firstUniqChar(s));
  }
}
