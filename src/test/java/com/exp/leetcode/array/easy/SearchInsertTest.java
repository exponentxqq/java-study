package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 3:54 PM */
public class SearchInsertTest {
  @Test
  void test1() {
    SearchInsert searchInsert = new SearchInsert();

    int[] nums = {1, 3, 5, 6};
    int target = 7;

    int expect = 4;
    Assertions.assertEquals(expect, searchInsert.searchInsert1(nums, target));
  }
}
