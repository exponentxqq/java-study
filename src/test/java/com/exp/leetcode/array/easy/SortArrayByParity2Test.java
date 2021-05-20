package com.exp.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortArrayByParity2Test {
  @Test
  void test1() {
    final SortArrayByParity2 sortArrayByParity = new SortArrayByParity2();

    int[] nums = {4, 2, 5, 7};

    List<int[]> expecteds =
        List.of(
            new int[] {4, 5, 2, 7},
            new int[] {4, 7, 2, 5},
            new int[] {2, 5, 4, 7},
            new int[] {2, 7, 4, 5});

    final int[] res = sortArrayByParity.sortArrayByParityII(nums);
    Assertions.assertTrue(expecteds.stream().anyMatch(expected -> Arrays.equals(expected, res)));
  }
}
