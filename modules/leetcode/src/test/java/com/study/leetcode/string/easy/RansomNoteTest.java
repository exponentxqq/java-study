package com.study.leetcode.string.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RansomNoteTest {
  @Test
  void test1() {
    final RansomNote ransomNote = new RansomNote();

    String note = "a";
    String magazine = "b";

    boolean expected = false;

    Assertions.assertEquals(expected, ransomNote.canConstruct(note, magazine));
  }

  @Test
  void test2() {
    final RansomNote ransomNote = new RansomNote();

    String note = "aa";
    String magazine = "ab";

    boolean expected = false;

    Assertions.assertEquals(expected, ransomNote.canConstruct(note, magazine));
  }

  @Test
  void test3() {
    final RansomNote ransomNote = new RansomNote();

    String note = "aa";
    String magazine = "aab";

    boolean expected = true;

    Assertions.assertEquals(expected, ransomNote.canConstruct(note, magazine));
  }
}
