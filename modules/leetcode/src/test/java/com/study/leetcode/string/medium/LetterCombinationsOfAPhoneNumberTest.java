package com.study.leetcode.string.medium;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetterCombinationsOfAPhoneNumberTest {
  private final LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber =
      new LetterCombinationsOfAPhoneNumber();

  @Test
  void test1() {
    String s = "23";
    List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

    Assertions.assertArrayEquals(
        expected.toArray(), letterCombinationsOfAPhoneNumber.letterCombinations(s).toArray());
  }

  @Test
  void test2() {
    String s = "";
    List<String> expected = List.of();

    Assertions.assertArrayEquals(
        expected.toArray(), letterCombinationsOfAPhoneNumber.letterCombinations(s).toArray());
  }

  @Test
  void test3() {
    String s = "2";
    List<String> expected = List.of("a", "b", "c");

    Assertions.assertArrayEquals(
        expected.toArray(), letterCombinationsOfAPhoneNumber.letterCombinations(s).toArray());
  }
}
