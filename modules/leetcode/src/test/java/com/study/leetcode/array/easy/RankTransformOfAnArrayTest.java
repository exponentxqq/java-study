package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/22 11:01 PM */
public class RankTransformOfAnArrayTest {
  @Test
  void test1() {
    RankTransformOfAnArray rankTransformOfAnArray = new RankTransformOfAnArray();

    int[] arr = {40, 10, 20, 30};

    int[] expected = {4, 1, 2, 3};

    Assertions.assertArrayEquals(expected, rankTransformOfAnArray.arrayRankTransform(arr));
  }

  @Test
  void test2() {
    RankTransformOfAnArray rankTransformOfAnArray = new RankTransformOfAnArray();

    int[] arr = {100, 100, 100};

    int[] expected = {1, 1, 1};

    Assertions.assertArrayEquals(expected, rankTransformOfAnArray.arrayRankTransform(arr));
  }

  @Test
  void test3() {
    RankTransformOfAnArray rankTransformOfAnArray = new RankTransformOfAnArray();

    int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};

    int[] expected = {5, 3, 4, 2, 8, 6, 7, 1, 3};

    Assertions.assertArrayEquals(expected, rankTransformOfAnArray.arrayRankTransform(arr));
  }
}
