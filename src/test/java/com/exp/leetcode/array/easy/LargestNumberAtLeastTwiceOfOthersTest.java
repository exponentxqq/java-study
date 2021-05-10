package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestNumberAtLeastTwiceOfOthersTest {
  @Test
  void test1() {
    final LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers =
        new LargestNumberAtLeastTwiceOfOthers();

    int[] nums = {3, 6, 1, 0};

    int expect = 1;

    Assertions.assertEquals(expect, largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
  }

  @Test
  void test2() {
    final LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers =
        new LargestNumberAtLeastTwiceOfOthers();

    int[] nums = {1, 2, 3, 4};

    int expect = -1;

    Assertions.assertEquals(expect, largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
  }

  @Test
  void test3() {
    final LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers =
        new LargestNumberAtLeastTwiceOfOthers();

    int[] nums = {1};

    int expect = 0;

    Assertions.assertEquals(expect, largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
  }

  @Test
  void test4() {
    final LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers =
        new LargestNumberAtLeastTwiceOfOthers();

    int[] nums = {1, 0};

    int expect = 0;

    Assertions.assertEquals(expect, largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
  }
}
