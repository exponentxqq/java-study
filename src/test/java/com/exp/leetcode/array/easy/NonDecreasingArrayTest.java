package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonDecreasingArrayTest {
  @Test
  void test1() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {4, 2, 3};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test2() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {4, 2, 3, 5};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test3() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {4, 2, 1};

    boolean expect = false;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test4() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {-1, 4, 2, 3};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test5() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {3, 4, 2, 3};

    boolean expect = false;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test6() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {1};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test7() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {2, 1};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test8() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {1, 2, 3};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }

  @Test
  void test9() {
    final NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();

    int[] nums = {5, 7, 1, 8};

    boolean expect = true;

    Assertions.assertEquals(expect, nonDecreasingArray.checkPossibility(nums));
  }
}
