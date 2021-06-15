package com.exp.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueMorseCodeWordsTest {
  @Test
  void test1() {
    final UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();

    String[] words = {"gin", "zen", "gig", "msg"};
    // "gin" -> "--...-."
    // "zen" -> "--...-."
    // "gig" -> "--...--."
    // "msg" -> "--...--."

    int expected = 2;

    Assertions.assertEquals(expected, uniqueMorseCodeWords.uniqueMorseRepresentations(words));
  }
}
