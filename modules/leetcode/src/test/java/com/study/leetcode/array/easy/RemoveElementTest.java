package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 3:52 PM */
public class RemoveElementTest {
  @Test
  void test1() {
    RemoveElement removeElement = new RemoveElement();

    int[] nums = {3, 2, 2, 3, 1, 4, 6, 7, 3};
    int val = 3;

    int expectLength = 6;

    Assertions.assertEquals(expectLength, removeElement.removeElement(nums, val));
  }
}
