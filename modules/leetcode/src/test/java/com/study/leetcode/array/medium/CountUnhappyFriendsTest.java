package com.study.leetcode.array.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountUnhappyFriendsTest {
  @Test
  void test1() {
    final CountUnhappyFriends countUnhappyFriends = new CountUnhappyFriends();

    int n = 4;
    int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
    int[][] pairs = {{0, 1}, {2, 3}};

    int expect = 2;

    Assertions.assertEquals(expect, countUnhappyFriends.unhappyFriends(n, preferences, pairs));
  }
}
