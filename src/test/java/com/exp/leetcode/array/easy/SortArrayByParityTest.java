package com.exp.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortArrayByParityTest {
  @Test
  void test1() {
    final SortArrayByParity sortArrayByParity = new SortArrayByParity();

    int[] nums = {3, 1, 2, 4};

    List<int[]> expecteds =
        List.of(
            new int[] {2, 4, 3, 1},
            new int[] {2, 4, 1, 3},
            new int[] {4, 2, 1, 3},
            new int[] {4, 2, 3, 1});
    final int[] res = sortArrayByParity.sortArrayByParity(nums);
    Assertions.assertTrue(expecteds.stream().anyMatch(expected -> Arrays.equals(expected, res)));
  }
}
