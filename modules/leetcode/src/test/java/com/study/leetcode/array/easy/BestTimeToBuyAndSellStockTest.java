package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** @date 2021/4/24 5:15 PM */
public class BestTimeToBuyAndSellStockTest {
  @Test
  void test1() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

    int[] prices = {7, 1, 5, 3, 6, 4};

    int expect = 5;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit2(prices));
  }

  @Test
  void test2() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

    int[] prices = {7, 6, 4, 3, 1};

    int expect = 0;

    Assertions.assertEquals(expect, bestTimeToBuyAndSellStock.maxProfit2(prices));
  }
}
