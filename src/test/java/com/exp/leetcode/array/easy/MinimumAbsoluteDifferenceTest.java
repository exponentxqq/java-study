package com.exp.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/25 12:08 AM */
public class MinimumAbsoluteDifferenceTest {
  @Test
  void test1() {
    MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();

    int[] arr = {4, 2, 1, 3};

    List<List<Integer>> expected = List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4));

    Assertions.assertEquals(expected, minimumAbsoluteDifference.minimumAbsDifference(arr));
  }

  @Test
  void test2() {
    MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();

    int[] arr = {1, 3, 6, 10, 15};

    List<List<Integer>> expected = List.of(List.of(1, 3));

    Assertions.assertEquals(expected, minimumAbsoluteDifference.minimumAbsDifference(arr));
  }
}
