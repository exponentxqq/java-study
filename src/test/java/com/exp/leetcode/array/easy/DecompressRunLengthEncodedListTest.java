package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/5/22 10:51 PM */
public class DecompressRunLengthEncodedListTest {
  @Test
  void test1() {
    DecompressRunLengthEncodedList decompressRunLengthEncodedList =
        new DecompressRunLengthEncodedList();

    int[] nums = {1, 2, 3, 4};

    int[] expected = {2, 4, 4, 4};

    Assertions.assertArrayEquals(expected, decompressRunLengthEncodedList.decompressRLElist(nums));
  }

  @Test
  void test2() {
    DecompressRunLengthEncodedList decompressRunLengthEncodedList =
        new DecompressRunLengthEncodedList();

    int[] nums = {1, 1, 2, 3};

    int[] expected = {1, 3, 3};

    Assertions.assertArrayEquals(expected, decompressRunLengthEncodedList.decompressRLElist(nums));
  }
}
