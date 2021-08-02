package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindCommonCharactersTest {
  @Test
  void test1() {
    final FindCommonCharacters findCommonCharacters = new FindCommonCharacters();

    String[] words = {"bella", "label", "roller"};

    List<String> expected = List.of("e", "l", "l");

    Assertions.assertEquals(expected, findCommonCharacters.commonChars(words));
  }

  @Test
  void test2() {
    final FindCommonCharacters findCommonCharacters = new FindCommonCharacters();

    String[] words = {"cool", "lock", "cook"};

    List<String> expected = List.of("c", "o");

    Assertions.assertEquals(expected, findCommonCharacters.commonChars(words));
  }
}
