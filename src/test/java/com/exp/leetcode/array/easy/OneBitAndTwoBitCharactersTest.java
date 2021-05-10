package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneBitAndTwoBitCharactersTest {
  @Test
  void test1() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 0, 0};

    boolean expect = true;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test2() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 1, 1, 0};

    boolean expect = false;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test3() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 0};

    boolean expect = false;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test4() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {0};

    boolean expect = true;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test5() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 1, 0};

    boolean expect = true;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test6() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 1, 1, 1, 0};

    boolean expect = true;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }

  @Test
  void test7() {
    final OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new OneBitAndTwoBitCharacters();

    int[] bits = {1, 1, 0, 0};

    boolean expect = true;

    Assertions.assertEquals(expect, oneBitAndTwoBitCharacters.isOneBitCharacter(bits));
  }
}
