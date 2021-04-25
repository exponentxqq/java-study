package com.exp.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanPlaceFlowersTest {
  @Test
  void test1() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {1, 0, 0, 0, 1};
    int n = 1;

    boolean expect = true;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }

  @Test
  void test2() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {1, 1};
    int n = 1;

    boolean expect = false;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }

  @Test
  void test3() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {1, 0};
    int n = 1;

    boolean expect = false;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }

  @Test
  void test4() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {0, 0, 1};
    int n = 1;

    boolean expect = true;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }

  @Test
  void test5() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {1, 0, 0};
    int n = 1;

    boolean expect = true;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }

  @Test
  void test6() {
    final CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

    int[] nums = {1, 0, 1, 0, 1, 0, 1};
    int n = 1;

    boolean expect = false;

    Assertions.assertEquals(expect, canPlaceFlowers.canPlaceFlowers(nums, n));
  }
}
