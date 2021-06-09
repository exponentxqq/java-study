package com.exp.leetcode.dynamicprogramming.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisorGameTest {
  @Test
  void test1() {
    final DivisorGame divisorGame = new DivisorGame();

    int n = 2;

    boolean expected = true;

    Assertions.assertEquals(expected, divisorGame.divisorGame(n));
  }

  @Test
  void test2() {
    final DivisorGame divisorGame = new DivisorGame();

    int n = 3;

    boolean expected = false;

    Assertions.assertEquals(expected, divisorGame.divisorGame(n));
  }
}
