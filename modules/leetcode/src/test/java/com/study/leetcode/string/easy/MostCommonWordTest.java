package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MostCommonWordTest {
  @Test
  void test1() {
    final MostCommonWord mostCommonWord = new MostCommonWord();

    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};

    String expected = "ball";

    Assertions.assertEquals(expected, mostCommonWord.mostCommonWord(paragraph, banned));
  }

  @Test
  void test2() {
    final MostCommonWord mostCommonWord = new MostCommonWord();

    String paragraph = "Bob!";
    String[] banned = {"hit"};

    String expected = "bob";

    Assertions.assertEquals(expected, mostCommonWord.mostCommonWord(paragraph, banned));
  }

  @Test
  void test3() {
    final MostCommonWord mostCommonWord = new MostCommonWord();

    String paragraph = "a, a, a, a, b,b,b,c, c";

    String[] banned = {"a"};

    String expected = "b";

    Assertions.assertEquals(expected, mostCommonWord.mostCommonWord(paragraph, banned));
  }

  @Test
  void test4() {
    final MostCommonWord mostCommonWord = new MostCommonWord();

    String paragraph = "Bob";
    String[] banned = {};

    String expected = "bob";

    Assertions.assertEquals(expected, mostCommonWord.mostCommonWord(paragraph, banned));
  }
}
