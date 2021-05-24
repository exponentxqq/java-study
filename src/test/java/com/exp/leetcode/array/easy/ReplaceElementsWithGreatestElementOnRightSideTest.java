package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/22 4:27 PM */
public class ReplaceElementsWithGreatestElementOnRightSideTest {
  @Test
  void test1() {
    ReplaceElementsWithGreatestElementOnRightSide replaceElementsWithGreatestElementOnRightSide =
        new ReplaceElementsWithGreatestElementOnRightSide();

    int[] arr = {17, 18, 5, 4, 6, 1};

    int[] expected = {18, 6, 6, 6, 1, -1};

    Assertions.assertArrayEquals(
        expected, replaceElementsWithGreatestElementOnRightSide.replaceElements(arr));
  }

  @Test
  void test2() {
    ReplaceElementsWithGreatestElementOnRightSide replaceElementsWithGreatestElementOnRightSide =
        new ReplaceElementsWithGreatestElementOnRightSide();

    int[] arr = {400};

    int[] expected = {-1};

    Assertions.assertArrayEquals(
        expected, replaceElementsWithGreatestElementOnRightSide.replaceElements(arr));
  }
}
