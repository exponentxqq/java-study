package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlippingAnImageTest {
  @Test
  void test1() {
    final FlippingAnImage flippingAnImage = new FlippingAnImage();

    int[][] image = {
      {1, 1, 0},
      {1, 0, 1},
      {0, 0, 0}
    };

    int[][] expected = {
      {1, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    };

    Assertions.assertArrayEquals(expected, flippingAnImage.flipAndInvertImage(image));
  }

  @Test
  void test2() {
    final FlippingAnImage flippingAnImage = new FlippingAnImage();

    int[][] image = {
      {1, 1, 0, 0},
      {1, 0, 0, 1},
      {0, 1, 1, 1},
      {1, 0, 1, 0},
    };

    int[][] expected = {
      {1, 1, 0, 0},
      {0, 1, 1, 0},
      {0, 0, 0, 1},
      {1, 0, 1, 0},
    };

    Assertions.assertArrayEquals(expected, flippingAnImage.flipAndInvertImage(image));
  }
}
