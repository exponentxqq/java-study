package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DuplicateZerosTest {
  @Test
  void test1() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

    int[] expected = {1, 0, 0, 2, 3, 0, 0, 4};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test2() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {1, 2, 3};

    int[] expected = {1, 2, 3};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test3() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};

    int[] expected = {8, 4, 5, 0, 0, 0, 0, 0};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test4() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {
      9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4,
      7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8,
      8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0
    };

    int[] expected = {
      9, 9, 9, 4, 8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 0, 0, 5,
      6, 3, 1, 6, 0, 0, 0, 0, 2, 3, 4, 7, 0, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 0, 0, 7, 3,
      3, 0, 0, 5, 7, 0, 0, 8, 1, 9, 6, 3, 0, 0, 8, 8, 8, 8, 0
    };

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test5() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {1, 5, 2, 0, 6, 8, 0, 6, 0};

    int[] expected = {1, 5, 2, 0, 0, 6, 8, 0, 0};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test6() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {1, 0, 1, 0, 0, 0};

    int[] expected = {1, 0, 0, 1, 0, 0};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }

  @Test
  void test7() {
    final DuplicateZeros duplicateZeros = new DuplicateZeros();

    int[] arr = {1, 0, 0, 1, 0, 0, 0};

    int[] expected = {1, 0, 0, 0, 0, 1, 0};

    duplicateZeros.duplicateZeros(arr);
    Assertions.assertArrayEquals(expected, arr);
  }
}
