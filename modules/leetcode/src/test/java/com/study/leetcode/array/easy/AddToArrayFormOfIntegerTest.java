package com.study.leetcode.array.easy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddToArrayFormOfIntegerTest {
  @Test
  void test1() {
    final AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();

    int[] nums = {1, 2, 0, 0};
    int k = 34;

    List<Integer> expected = List.of(1, 2, 3, 4);

    Assertions.assertEquals(expected, addToArrayFormOfInteger.addToArrayForm(nums, k));
  }

  @Test
  void test2() {
    final AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();

    int[] nums = {2, 7, 4};
    int k = 181;

    List<Integer> expected = List.of(4, 5, 5);

    Assertions.assertEquals(expected, addToArrayFormOfInteger.addToArrayForm(nums, k));
  }

  @Test
  void test3() {
    final AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();

    int[] nums = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    int k = 1;

    List<Integer> expected = List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    Assertions.assertEquals(expected, addToArrayFormOfInteger.addToArrayForm(nums, k));
  }

  @Test
  void test4() {
    final AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();

    int[] nums = {1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3};

    int k = 516;

    List<Integer> expected = List.of(1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 5, 7, 9);

    Assertions.assertEquals(expected, addToArrayFormOfInteger.addToArrayForm(nums, k));
  }
}
