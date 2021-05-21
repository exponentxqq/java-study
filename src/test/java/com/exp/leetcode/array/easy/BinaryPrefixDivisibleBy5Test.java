package com.exp.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryPrefixDivisibleBy5Test {
  @Test
  void test() {
    final int i = 1 << 1;
    Assertions.assertTrue(true);
  }

  @Test
  void test1() {
    final BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();

    int[] nums = {0, 1, 1};

    List<Boolean> expected = List.of(true, false, false);

    Assertions.assertEquals(expected, binaryPrefixDivisibleBy5.prefixesDivBy5(nums));
  }

  @Test
  void test2() {
    final BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();

    int[] nums = {1, 1, 1};

    List<Boolean> expected = List.of(false, false, false);

    Assertions.assertEquals(expected, binaryPrefixDivisibleBy5.prefixesDivBy5(nums));
  }

  @Test
  void test3() {
    final BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();

    int[] nums = {0, 1, 1, 1, 1, 1};

    List<Boolean> expected = List.of(true, false, false, false, true, false);

    Assertions.assertEquals(expected, binaryPrefixDivisibleBy5.prefixesDivBy5(nums));
  }

  @Test
  void test4() {
    final BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();

    int[] nums = {1, 1, 1, 0, 1};

    List<Boolean> expected = List.of(false, false, false, false, false);

    Assertions.assertEquals(expected, binaryPrefixDivisibleBy5.prefixesDivBy5(nums));
  }

  @Test
  void test5() {
    final BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();

    int[] nums = {
      1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0,
      1, 1, 0, 1, 0, 0, 0, 1
    };

    List<Boolean> expected =
        List.of(
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, true, false, false, true, true, true,
            true, false);

    Assertions.assertEquals(expected, binaryPrefixDivisibleBy5.prefixesDivBy5(nums));
  }
}
