package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 5:28 PM */
public class BestTimeToBuyAndSellStock2Test {
  @Test
  void test1() {
    BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();

    int[] prices = {7, 1, 5, 3, 6, 4};

    int expect = 7;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit(prices));
  }

  @Test
  void test2() {
    BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();

    int[] prices = {7, 6, 4, 3, 1};

    int expect = 0;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit(prices));
  }

  @Test
  void test3() {
    BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();

    int[] prices = {2, 1, 3, 4, 5};

    int expect = 4;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit(prices));
  }

  @Test
  void test4() {
    BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();

    int[] prices = {1, 6, 3, 2, 7, 9};

    int expect = 12;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit(prices));
  }
}
