package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DetectCapitalTest {
  @Test
  void test1() {
    final DetectCapital detectCapital = new DetectCapital();

    String word = "USA";

    boolean expected = true;

    Assertions.assertEquals(expected, detectCapital.detectCapitalUse(word));
  }

  @Test
  void test2() {
    final DetectCapital detectCapital = new DetectCapital();

    String word = "FlaG";

    boolean expected = false;

    Assertions.assertEquals(expected, detectCapital.detectCapitalUse(word));
  }

  @Test
  void test3() {
    final DetectCapital detectCapital = new DetectCapital();

    String word = "flaG";

    boolean expected = false;

    Assertions.assertEquals(expected, detectCapital.detectCapitalUse(word));
  }
}
