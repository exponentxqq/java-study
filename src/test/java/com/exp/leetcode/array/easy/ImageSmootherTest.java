package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageSmootherTest {
  @Test
  void test1() {
    final ImageSmoother imageSmoother = new ImageSmoother();

    int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    int[][] expect = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    Assertions.assertArrayEquals(expect, imageSmoother.imageSmoother(img));
  }

  @Test
  void test2() {
    final ImageSmoother imageSmoother = new ImageSmoother();

    int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};

    int[][] expect = {{137, 141, 137}, {141, 138, 141}, {137, 141, 137}};
    // [[137,94,45],[141,89,44],[137,94,45]]
    Assertions.assertArrayEquals(expect, imageSmoother.imageSmoother(img));
  }
}
