package com.study.leetcode.array.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciNumberTest {
  @Test
  void test1() {
    final FibonacciNumber fibonacciNumber = new FibonacciNumber();

    int n = 2;

    int expected = 1;

    Assertions.assertEquals(expected, fibonacciNumber.fib(n));
  }

  @Test
  void test2() {
    final FibonacciNumber fibonacciNumber = new FibonacciNumber();

    int n = 3;

    int expected = 2;

    Assertions.assertEquals(expected, fibonacciNumber.fib(n));
  }
}
