package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveZeroesTest {
  @Test
  void test1() {
    final MoveZeroes moveZeroes = new MoveZeroes();

    int[] nums = {0, 1, 0, 3, 12};

    int[] expect = {1, 3, 12, 0, 0};

    moveZeroes.moveZeroes2(nums);
    Assertions.assertArrayEquals(expect, nums);
  }

  @Test
  void test2() {
    final MoveZeroes moveZeroes = new MoveZeroes();

    int[] nums = {0, 1};

    int[] expect = {1, 0};

    moveZeroes.moveZeroes2(nums);
    Assertions.assertArrayEquals(expect, nums);
  }

  @Test
  void test3() {
    final MoveZeroes moveZeroes = new MoveZeroes();

    int[] nums = {0, 0};

    int[] expect = {0, 0};

    moveZeroes.moveZeroes2(nums);
    Assertions.assertArrayEquals(expect, nums);
  }

  @Test
  void test4() {
    final MoveZeroes moveZeroes = new MoveZeroes();

    int[] nums = {2, 1};

    int[] expect = {2, 1};

    moveZeroes.moveZeroes2(nums);
    Assertions.assertArrayEquals(expect, nums);
  }
}
