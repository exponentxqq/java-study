package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XOfAKindInADeckOfCardsTest {
  @Test
  void test1() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
    // 可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]

    boolean expected = true;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }

  @Test
  void test2() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};

    boolean expected = false;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }

  @Test
  void test3() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {1};

    boolean expected = false;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }

  @Test
  void test4() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {1, 1};

    boolean expected = true;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }

  @Test
  void test5() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {1, 1, 2, 2, 2, 2};
    // 可行的分组是 [1,1]，[2,2]，[2,2]

    boolean expected = true;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }

  @Test
  void test6() {
    final XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();

    int[] deck = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    // 可行的分组是 [0, 0, ]，[1, 1, 1]，[2, 2, 2]

    boolean expected = true;

    Assertions.assertEquals(expected, xOfAKindInADeckOfCards.hasGroupsSizeX(deck));
  }
}
