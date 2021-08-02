package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionsOfLargeGroupsTest {
  @Test
  void test1() {
    final PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();

    String s = "abbxxxxzzy";

    List<List<Integer>> expected = List.of(List.of(3, 6));

    Assertions.assertEquals(expected, positionsOfLargeGroups.largeGroupPositions(s));
  }

  @Test
  void test2() {
    final PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();

    String s = "abc";

    List<List<Integer>> expected = List.of();

    Assertions.assertEquals(expected, positionsOfLargeGroups.largeGroupPositions(s));
  }

  @Test
  void test3() {
    final PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();

    String s = "abcdddeeeeaabbbcd";

    List<List<Integer>> expected = List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14));

    Assertions.assertEquals(expected, positionsOfLargeGroups.largeGroupPositions(s));
  }

  @Test
  void test4() {
    final PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();

    String s = "aaa";

    List<List<Integer>> expected = List.of(List.of(0, 2));

    Assertions.assertEquals(expected, positionsOfLargeGroups.largeGroupPositions(s));
  }

  @Test
  void test5() {
    final PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();

    String s = "bbbcdefaaa";

    List<List<Integer>> expected = List.of(List.of(0, 2), List.of(7, 9));

    Assertions.assertEquals(expected, positionsOfLargeGroups.largeGroupPositions(s));
  }
}
